package exceptions;

public class NoClothes extends RuntimeException {
    public NoClothes() {
        super();
    }

    @Override
    public String getMessage() {
        return "Не осталось ни одного элемента одежды!!!";
    }
}
