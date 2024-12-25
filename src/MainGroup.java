import exceptions.NoOnePerson;
import personality.Shorty;
import point.AnotherPlace;
import point.Place;
import thing.Clothes;
import thing.Envelop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainGroup {
    private final Envelop envelop;
    private final ArrayList<Shorty> characters;
    private Place currentPlace;
    private int possibleTime;
    private Place target;

    private static int countRest;

    static {
        countRest = 0;
    }


    public MainGroup(Place currentPlace, Envelop envelop, Shorty... characters) {
        this.currentPlace = currentPlace;
        this.characters = new ArrayList<>(List.of(characters));
        this.envelop = envelop;
    }

    public void setCurrentPlace(Place currentPlace) {
        this.currentPlace = currentPlace;
    }

    public Place getCurrentPlace() {
        return currentPlace;
    }

    public void addCharacters(Shorty... characters) {
        for (Shorty i : characters) {
            if (this.characters.contains(i)) {
                continue;
            }
            this.characters.add(i);
        }
    }

    public void read() {
        try {
            if (characters.isEmpty()) {
                throw new NoOnePerson();
            }
            Shorty reader = characters.get(new Random().nextInt(characters.size()));
            System.out.println(reader.getName() + " поднял конверт и прочитал надпись на нем: " + envelop.title());
            this.target = envelop.getAddress();
        } catch (NoOnePerson e) {
            System.out.println(e.getMessage());
        }
    }

    public void hide() {
        Shorty hider = characters.get(new Random().nextInt(characters.size()));
        if (!hider.getClothes().isEmpty()) {
            Clothes cl = hider.getClothes().get(new Random().nextInt(hider.getClothes().size()));
            System.out.println(hider.getName() + " спрятал письмо обратно в " + cl.getName() + ".");
        } else {
            System.out.println(hider.getName() + " спрятал письмо.");
        }
    }

    public void goTo(JourneyTime time) {
        this.currentPlace = new AnotherPlace("Где-то");
        System.out.println("Группа отправилась в " + envelop.getAddress().title());
        this.setPossibleTime();
        while (time.getCurrentTime() + possibleTime < time.getAllTime()) {
            time.pass(possibleTime);
            time.addCurrentTime(possibleTime);
            rest();
            time.pass(possibleTime / 5);
            if (Math.random() < 0.5) {
                currentPlace.changeWeather();
            }
            if (Math.random() < 0.05) {
                currentPlace.storm(characters);
                time.pass(possibleTime);
            }
            this.setPossibleTime();
        }
        time.pass(time.getAllTime() - time.getCurrentTime());
        System.out.println(time.passedTime() + " группа добралась до цели.");
        this.setCurrentPlace(target);
    }

    public void rest() {
        countRest++;
        System.out.println("Часть группы устала, поэтому ребята устроили перерыв " + countRest + "-й раз");

        for (Shorty i : characters) {
            for (Clothes j : i.getClothes()) {
                if (j.isDirty()) {
                    j.cleanIt();
                }
            }
        }

        if (Math.random() < 0.05) {
            meet();
        }

    }

    public void setPossibleTime() {
        int res = Integer.MAX_VALUE;
        for (Shorty i : this.characters) {
            if (i.calculatePossibleMinutes() < res) {
                res = i.calculatePossibleMinutes();
            }
        }
        currentPlace.getWeather().describe();
        switch (currentPlace.getWeather()) {
            case RAINY:
                res = res * 8 / 10;
                chanceToDirty(0.4f);
                break;
            case SNOWY:
                res = res / 2;
                chanceToDirty(0.1f);
                break;
            case SUNNY:
                res = res * 11 / 10;
        }
        this.possibleTime = res;
    }

    public void meet() {
        Shorty unnamed = new Shorty();
        System.out.println("Во время отдыха группа встрелила " + unnamed.getName() + ". Он сказал, что идет туда же, " +
                "куда и группа.");
        System.out.println("Принять его в группу?(Да / Нет)");
        String answer = new Scanner(System.in).next();
        if (answer.equals("Да")) {
            this.addCharacters(unnamed);
        } else if (answer.equals("Нет")) {
            System.out.println("Группа не приняла " + unnamed.getName() + " и он ушел восвояси.");
        } else {
            System.out.println("Не дождавшись внятного ответа, незнакомец скрылся.");
        }
    }

    public void chanceToDirty(float chance) {
        for (Shorty i : characters) {
            if (Math.random() < chance) {
                if (!i.getClothes().isEmpty()) {
                    i.dirtySomeClothe();
                }
                System.out.println(i.getName() + " испачкался. ");
            }
        }
    }
}
