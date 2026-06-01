package Patterns.COR;

public class Main {
    public static void main(String[] args) {
        Handler hundredHandler = new HundredHandler(null);
        hundredHandler.setTotalNotes(1);
        Handler fiveHundredHandler = new FiveHundredHandler(hundredHandler);
        fiveHundredHandler.setTotalNotes(5);
        Handler thousandHandler = new ThousandHandler(fiveHundredHandler);
        thousandHandler.setTotalNotes(3);

        
        thousandHandler.handle(200);
        thousandHandler.handle(10000);
    }
}


