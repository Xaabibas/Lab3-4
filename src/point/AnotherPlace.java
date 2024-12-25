package point;

import exceptions.NoClothes;
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
        System.out.println("Каратышки попали в шторм!");
        this.setWeather(Weather.RAINY);
        for (Shorty i : shorties) {
            try {
                i.changeEndurance(-15);
                if (i.getClothes().isEmpty()) {
                    throw new NoClothes();
                }
                i.removeClothes(i.getClothes().get(new Random().nextInt()));
            } catch (NoClothes e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getName() {
        return name;
    }
}
