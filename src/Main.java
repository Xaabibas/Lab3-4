import personality.ImportantPerson;
import personality.Person;
import personality.Shorty;
import point.*;
import thing.Envelop;

public class Main {
    public static void main(String[] args) {
        Shorty kozlik = new Shorty("Козлик", 40);
        Shorty dunno = new Shorty("Незнайка", 50);
        Place start = new AnotherPlace("Где-то");
        Street street = new Street("Пушкина");
        Alleyway alleyway = new Alleyway("Колотушкина");
        TownPlace end = new TownPlace(street, alleyway, 12);
        Person julio = new ImportantPerson("Жулио", "владелец продуктового магазина");
        Envelop envelop = new Envelop(end, julio);
        MainGroup mg = new MainGroup(start, envelop, kozlik, dunno);
        mg.read();
        mg.hide();
        JourneyTime journeyTime = new JourneyTime(1, 30);
        mg.goTo(journeyTime);
    }
}