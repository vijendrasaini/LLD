package Patterns.COR;

public class ThousandHandler extends Handler {
    public ThousandHandler(int totalNotes, Handler nextHandler) {
        super(1000, totalNotes, nextHandler);
    }
}
