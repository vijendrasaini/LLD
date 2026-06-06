package Patterns.Adapter;

public class Main {
    public static void main(String[] args) {
        PaymentGateway razorpay = new RazorPay();
        CheckoutService checkoutService = new CheckoutService(razorpay);
        
        checkoutService.checkout(100);
    }
}
