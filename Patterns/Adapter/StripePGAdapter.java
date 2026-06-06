package Patterns.Adapter;

public class StripePGAdapter implements PaymentGateway {
    
    private StripeApi stripeApi;
    public StripePGAdapter(StripeApi stripeApi) {
        this.stripeApi = stripeApi;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment by Stripe");
        stripeApi.makePayment(amount);
    }    
}