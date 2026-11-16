package strategy;

import model.ParkingSpot;
import model.Vehicle;

public interface SpotAssignmentStrategy {
    ParkingSpot getParkingSpot(Vehicle vehicle);
}
