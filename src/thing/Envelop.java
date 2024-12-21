package thing;

import interfaces.Titlable;
import personality.Person;
import point.TownPlace;

public class Envelop extends Thing implements Titlable {
    private TownPlace address;
    private Person addressee;

    public Envelop(TownPlace address, Person addressee) {
        this.address = address;
        this.addressee = addressee;
    }

    @Override
    public String title() {
        if (this.isDirty()){
            return  "Надпись на конверте была замазана, но адрес был виден: \"" + this.address.title() + "\"";
        }
        return "\"" + this.address.title() + ". " + this.addressee.getFullName() + "\"";
    }

    public void rewriteTitle(Person addressee, TownPlace address){
        this.address =address;
        this.addressee = addressee;
    }

    public Person getAddressee() {
        return addressee;
    }

    public TownPlace getAddress() {
        return address;
    }
}
