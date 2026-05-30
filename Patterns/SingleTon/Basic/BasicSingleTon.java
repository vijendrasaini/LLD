package Patterns.SingleTon.Basic;

public class BasicSingleTon {
    private static BasicSingleTon instance;
    private BasicSingleTon() {

    }

    public static BasicSingleTon getInstance() {
        if(instance == null ) {
            instance = new BasicSingleTon();
        }

        return instance;
    }
}
