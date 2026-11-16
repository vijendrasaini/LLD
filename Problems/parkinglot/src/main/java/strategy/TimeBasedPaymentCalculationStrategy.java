package strategy;

import model.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeBasedPaymentCalculationStrategy implements PaymentCalculationStrategy {
    @Override
    public double getPayment(ParkingTicket parkingTicket) {
        LocalDateTime current = LocalDateTime.now();

        Duration duration = Duration.between(current, parkingTicket.getCreatedAt());
        long hours = duration.toHours();

        if(hours > 0) {
            return hours * 10;
        } else {
            long minutes = duration.toMillis();
            return minutes * ( 1.0 / 7);
        }
    }
}
