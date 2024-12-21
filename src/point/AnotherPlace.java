package point;

public class AnotherPlace extends Place{
    private final String name;

    public AnotherPlace(String name){
        super(Weather.getRandomWeather());
        this.name = name;
    }

    @Override
    public String title() {
        return name;
    }
}
