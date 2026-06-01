package Patterns.COR;

public class ThousandHandler extends Handler {
    public ThousandHandler(Handler nextHandler) {
        super(1000, nextHandler);
    }
}
