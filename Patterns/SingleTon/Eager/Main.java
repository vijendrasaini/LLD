package Patterns.SingleTon.Eager;

public class Main {
    public static void main(String[] args) {
        System.out.println(EagerSingleTon.getInstance() == EagerSingleTon.getInstance());
    }
}
