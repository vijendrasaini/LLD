package Patterns.SingleTon.Basic;

public class Main {
    public static void main(String[] args) {
        // BasicSingleTon instance1 = new BasicSingleTon();
        // BasicSingleTon instance2 = new BasicSingleTon();
        // System.out.println(instance1 == instance2);
        
        
        BasicSingleTon instance1 = BasicSingleTon.getInstance();
        BasicSingleTon instance2 = BasicSingleTon.getInstance();
        System.out.println(instance1 == instance2);
        
    }
}
