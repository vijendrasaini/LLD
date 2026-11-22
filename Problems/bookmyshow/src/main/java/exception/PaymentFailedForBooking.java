package exception;

public class PaymentFailedForBooking extends RuntimeException {
    public PaymentFailedForBooking(String paymentFailed) {
        super(paymentFailed);
    }
}
