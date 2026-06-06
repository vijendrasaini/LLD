package Patterns.Adapter;

public class Main {
    public static void main(String[] args) {
        // CheckoutService checkoutService = new CheckoutService(new RazorPay());
        CheckoutService checkoutService = new CheckoutService(new StripePGAdapter(new StripeApi())); // Adparter saves our life without making changes in existing working code
        
        checkoutService.checkout(100);
    }
}
