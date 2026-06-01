package Patterns.COR;

public class FiveHundredHandler extends Handler {
    public FiveHundredHandler(Handler nextHandler) {
        super(500, nextHandler);
    }
}