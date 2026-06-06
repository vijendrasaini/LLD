package Patterns.Adapter;

import Patterns.Adapter.pgadapter.PaypalPGAdapter;
import Patterns.Adapter.pgadapter.StripePGAdapter;

public class Main {
    public static void main(String[] args) {
        // CheckoutService checkoutService = new CheckoutService(new RazorPay());
        // CheckoutService checkoutService = new CheckoutService(new StripePGAdapter(new StripeApi())); // Adparter saves our life without making changes in existing working code
        CheckoutService checkoutService = new CheckoutService(new PaypalPGAdapter(new PaypalApi())); // Adparter saves our life without making changes in existing working code
        
        checkoutService.checkout(100);
    }
}
