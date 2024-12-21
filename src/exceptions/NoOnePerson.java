package exceptions;

public class NoOnePerson extends Exception {
    public NoOnePerson() {
        super();
    }

    @Override
    public String getMessage() {
        return "Нет ни одного человека!!!";
    }
}
