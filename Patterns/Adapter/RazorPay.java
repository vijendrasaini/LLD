package Patterns.Adapter;

public class RazorPay implements PaymentGateway{
    @Override
    public void processPayment(double amount) {
        System.out.println("Payment by Razor pay");
    }
}
