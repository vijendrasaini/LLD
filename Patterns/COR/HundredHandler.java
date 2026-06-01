package Patterns.COR;

public class HundredHandler extends Handler{
    public HundredHandler(Handler nextHandler) {
        super(100, nextHandler);
    }
}
