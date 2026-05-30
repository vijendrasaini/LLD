package Patterns.SingleTon.Eager;

// not usefull when object creattion is too expensive ( usecase : what if we don't 
// use the single tone object still it will be created inthe application)
public class EagerSingleTon {
    private static EagerSingleTon instance = new EagerSingleTon();
    
    private EagerSingleTon() {};

    public static EagerSingleTon getInstance() {
        return instance;
    }
}
