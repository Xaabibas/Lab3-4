package exceptions;

public class NegTime extends RuntimeException {
    public NegTime() {
        super();
    }

  @Override
  public String getMessage() {
    return "Время не может быть отрицательным!!!";
  }
}
