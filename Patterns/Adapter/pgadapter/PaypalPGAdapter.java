package Patterns.Adapter.pgadapter;

import Patterns.Adapter.PaymentGateway;
import Patterns.Adapter.PaypalApi;

public class PaypalPGAdapter implements PaymentGateway {
    private PaypalApi paypalApi;
    public PaypalPGAdapter(PaypalApi paypalApi) {
        this.paypalApi = paypalApi;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Payment by Paypal");
        paypalApi.executePayment(amount);
    }
    
}
