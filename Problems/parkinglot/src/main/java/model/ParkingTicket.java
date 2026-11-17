package model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTicket {
    String number;
    ParkingSpot parkingSpot;
    Vehicle vehicle;
    LocalDateTime createdAt;
    LocalDateTime exitedAt;
    double paymentAmount;

    public ParkingTicket(ParkingSpot parkingSpot, Vehicle vehicle) {
        this.number = UUID.randomUUID().toString().substring(0, 10);
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        this.createdAt = LocalDateTime.now();
        this.exitedAt = null;
    }

    public static ParkingTicket create(ParkingSpot parkingSpot, Vehicle vehicle) {
        return new ParkingTicket(parkingSpot, vehicle);
    }

    public void makeSpotAvailable() {
        this.parkingSpot.makeAvailable();
    }

    @Override
    public String toString() {
        return "Number: %s \nCreated-At: %s\nClosed-At: %s\nPayment-Amount: %f".formatted(number, createdAt, exitedAt, paymentAmount);
    }

    public void markClosed() {
        this.exitedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }
}
