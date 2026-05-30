package Patterns.SingleTon.DoubleChecked;

public class Main {
    public static void main(String[] args) {
        System.out.println(DoubleChecked.getInstance() == DoubleChecked.getInstance());
    }
}
