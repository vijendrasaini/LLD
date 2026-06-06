package Patterns.Adapter;

public class StripeApi {

    public void makePayment(double amount) {
        System.out.println(
            "Stripe Payment Processed : " + amount
        );
    }
}