package exception;

public class TimeToBookPassedException extends RuntimeException {
    public TimeToBookPassedException(String s) {
        super(s);
    }
}
