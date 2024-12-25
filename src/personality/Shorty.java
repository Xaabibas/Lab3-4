package personality;

import thing.Clothes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Shorty extends Person {
    private int endurance;
    private final ArrayList<Clothes> clothes;

    public Shorty(String name, int endurance) {
        super(name);
        this.endurance = Math.abs(endurance);
        this.clothes = new ArrayList<>();
    }

    public Shorty(String name) {
        super(name);
        this.endurance = 50;
        this.clothes = new ArrayList<>();
    }

    public Shorty() {
        super();
        this.endurance = new Random().nextInt(100);
        this.clothes = new ArrayList<>();
    }

    public void addClothes(Clothes... clothes) {
        this.clothes.addAll(Arrays.asList(clothes));
    }

    public void removeClothes(Clothes... clothes) {
        this.clothes.removeAll(Arrays.asList(clothes));
    }

    public void changeEndurance(int ch) {
        if (this.endurance + ch < 0) {
            this.endurance = 0;
        } else {
            this.endurance += ch;
        }
    }

    public int calculatePossibleMinutes() {
        return 7 * endurance * endurance / 100 + 3 * endurance / 2 + 10;
    }

    @Override
    public String getFullName() {
        return this.getName();
    }

    public void dirtySomeClothe() {
        if (!clothes.isEmpty()) {
            clothes.get(new Random().nextInt(clothes.size())).dirtyIt();
        }
    }

    public ArrayList<Clothes> getClothes() {
        return clothes;
    }
}
