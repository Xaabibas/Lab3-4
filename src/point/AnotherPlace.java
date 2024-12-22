package point;

import personality.Shorty;

import java.util.ArrayList;
import java.util.Random;

public class AnotherPlace extends Place{
    private final String name;

    public AnotherPlace(String name){
        super(Weather.getRandomWeather());
        this.name = name;
    }

    @Override
    public void storm(ArrayList<Shorty> shorties) {
        System.out.println("Каратышки попали в шторм!!!");
        this.setWeather(Weather.RAINY);
        for (Shorty i : shorties) {
            if (!i.getClothes().isEmpty()) {
                i.removeClothes(i.getClothes().get(new Random().nextInt()));
            }
            i.changeEndurance(-15);
        }
    }

    public String getName() {
        return name;
    }
}
