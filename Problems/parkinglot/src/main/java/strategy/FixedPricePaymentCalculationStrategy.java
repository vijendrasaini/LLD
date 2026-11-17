package strategy;

import model.ParkingTicket;

public class FixedPricePaymentCalculationStrategy implements PaymentCalculationStrategy {
    @Override
    public double getPayment(ParkingTicket parkingTicket) {
        return 5.0;
    }
}
