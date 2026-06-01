package Patterns.COR;

public class FiveHundredHandler extends Handler {
    public FiveHundredHandler(int totalNotes, Handler nextHandler) {
        super(500, totalNotes, nextHandler);
    }
}