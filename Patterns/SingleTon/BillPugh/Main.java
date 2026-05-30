package Patterns.SingleTon.BillPugh;

public class Main {
    public static void main(String[] args) {
        System.out.println(BillPugh.getInstance() == BillPugh.getInstance());
    }
}
