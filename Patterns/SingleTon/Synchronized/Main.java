package Patterns.SingleTon.Synchronized;

public class Main {
    public static void main(String[] args) {
        
        ThreadSafeSingleTon instance1 = ThreadSafeSingleTon.getInstance();
        ThreadSafeSingleTon instance2 = ThreadSafeSingleTon.getInstance();
        System.out.println(instance1 == instance2);
        
    }
}
