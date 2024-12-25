package exceptions;

public class NoOnePerson extends RuntimeException {
    public NoOnePerson() {
        super();
    }

    @Override
    public String getMessage() {
        return "Нет ни одного человека!!!";
    }
}
