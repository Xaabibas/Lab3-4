package point;

import interfaces.Titlable;
import personality.Shorty;

import java.util.ArrayList;
import java.util.Objects;

public class TownPlace extends Place implements Titlable {

    private final Street street;
    private final Alleyway alleyway;
    private final int house;

    public TownPlace(Street street, Alleyway alleyway, int house){
        super(Weather.getRandomWeather());
        this.street = street;
        this.alleyway = alleyway;
        this.house = house;
    }

    public  TownPlace(Street street, Alleyway alleyway, int house, Weather weather){
        super(weather);
        this.street = street;
        this.alleyway = alleyway;
        this.house = house;
    }

    public Alleyway getAlleyway() {
        return alleyway;
    }

    public Street getStreet() {
        return street;
    }

    public int getHouse() {
        return house;
    }

    @Override
    public void storm(ArrayList<Shorty> shorties) {
        System.out.println("Каратышки попали в шторм, но они успели спрятаться в доме, поэтому отделались легким испугом");
        for (Shorty i : shorties) {
            i.changeEndurance(-1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TownPlace townPlace = (TownPlace) o;
        return house == townPlace.house && Objects.equals(street, townPlace.street) && Objects.equals(alleyway, townPlace.alleyway);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, alleyway, house);
    }

    @Override
    public String toString() {
        return "TownPlace{" +
                "street=" + street +
                ", alleyway=" + alleyway +
                ", house=" + house +
                '}';
    }

    @Override
    public String title() {
        return this.street.name() + " улица, " + this.alleyway.name() + " переулок, дом № " + this.house;
    }
}
