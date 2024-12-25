package thing;

public class Clothes extends Thing {
    private final String name;

    public Clothes(String name) {
        super();
        this.name = name;
    }

    public Clothes(String name, boolean dirty) {
        super(dirty);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}