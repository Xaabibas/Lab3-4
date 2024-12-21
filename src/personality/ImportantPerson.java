package personality;

public class ImportantPerson extends Person{
    private String status;

    public ImportantPerson(String name, String status){
        super(name);
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String getFullName() {
        return this.status + ' ' + this.getName();
    }
}
