package strategy;

import model.ParkingTicket;

public interface PaymentCalculationStrategy {
    double getPayment(ParkingTicket parkingTicket);
}
