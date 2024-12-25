package exceptions;

public class NegTime extends Exception {
    public NegTime() {
        super();
    }

  @Override
  public String getMessage() {
    return "Время не может быть отрицательным!!!";
  }
}
