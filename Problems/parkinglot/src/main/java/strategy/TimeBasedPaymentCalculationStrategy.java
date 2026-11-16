package strategy;

import model.ParkingTicket;

public class TimeBasedPaymentCalculationStrategy implements PaymentCalculationStrategy {
    @Override
    public double getPayment(ParkingTicket parkingTicket) {
        return 0;
    }
}
