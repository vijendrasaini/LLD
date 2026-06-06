package Patterns.Adapter;

public class PaypalApi {

    public void executePayment(double amount) {
        System.out.println("Making payment of " + amount);
    }
}
