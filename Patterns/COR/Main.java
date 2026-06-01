package Patterns.COR;

public class Main {
    public static void main(String[] args) {
        Handler hundredHandler = new HundredHandler(1, null);
        Handler fiveHundredHandler = new FiveHundredHandler(5, hundredHandler);
        Handler thousandHandler = new ThousandHandler(3, fiveHundredHandler);

        thousandHandler.handle(3600);
    }
}


