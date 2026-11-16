import model.Floor;
import model.ParkingSpot;
import model.ParkingTicket;
import model.Vehicle;
import strategy.PaymentCalculationStrategy;
import strategy.SpotAssignmentStrategy;

import java.util.List;

public class ParkingLot {
    List<Floor> floorList;
    SpotAssignmentStrategy spotAssignmentStrategy;
    PaymentCalculationStrategy paymentCalculationStrategy;
    public ParkingLot(List<Floor> floorList, SpotAssignmentStrategy spotAssignmentStrategy, PaymentCalculationStrategy paymentCalculationStrategy) {
        this.floorList = floorList;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.paymentCalculationStrategy = paymentCalculationStrategy;
    }

    ParkingTicket parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = this.spotAssignmentStrategy.getParkingSpot(vehicle);

        parkingSpot.book();
        return ParkingTicket.create(parkingSpot, vehicle);
    }

    public ParkingTicket unparkVehicle(ParkingTicket parkingTicket) {
        parkingTicket.makeSpotAvailable();

        // Created charges/payment amount and get this paid
        double amount = this.paymentCalculationStrategy.getPayment(parkingTicket);
        // paying the amount here;

        parkingTicket.markClosed();
        return parkingTicket;
    }
}
