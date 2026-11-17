package strategy;

import model.ParkingTicket;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeBasedPaymentCalculationStrategy implements PaymentCalculationStrategy {
    @Override
    public double getPayment(ParkingTicket parkingTicket) {
        LocalDateTime current = LocalDateTime.now();

        Duration duration = Duration.between(parkingTicket.getCreatedAt(), current);
        long hours = duration.toHours();

        if(hours > 0) {
            return hours * 10;
        } else {
            long minutes = duration.toMillis();
            if(minutes > 10) {
                return minutes * ( 1.0 / 7);
            }

            return 5.0; // fixed charge for less than 10 minutes duration
        }
    }
}
