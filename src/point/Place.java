package point;

import personality.Shorty;

import java.util.ArrayList;

public abstract class Place {
    private Weather weather;

    public Place(Weather weather) {
        this.weather = weather;
    }

    public abstract void storm(ArrayList<Shorty> shorties);

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void changeWeather() {
        this.weather = Weather.getRandomWeather();
    }



}
