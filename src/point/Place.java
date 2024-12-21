package point;

import interfaces.Titlable;

public abstract class Place implements Titlable {
    private Weather weather;

    public Place(Weather weather) {
        this.weather = weather;
    }

    public Weather getWeather() {
        return weather;
    }

    public void changeWeather() {
        this.weather = Weather.getRandomWeather();
    }



}
