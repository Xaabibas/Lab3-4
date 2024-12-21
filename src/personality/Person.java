package personality;

public abstract class Person{
    private final String name;

    public Person(String name){
        this.name = name;
    }

    public abstract String getFullName();

    public Person(){
        this("Незнакомец");
    }

    public String getName() {
        return name;
    }


}
