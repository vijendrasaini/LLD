package Patterns.COR;

public class HundredHandler extends Handler {
    public HundredHandler(int totalNotes, Handler nextHandler) {
        super(100, totalNotes, nextHandler);
    }
}
