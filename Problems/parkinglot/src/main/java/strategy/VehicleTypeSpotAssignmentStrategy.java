package strategy;

import model.Floor;
import model.ParkingSpot;
import model.Vehicle;

import java.util.List;

public class VehicleTypeSpotAssignmentStrategy implements SpotAssignmentStrategy {
    private final List<Floor> floors;
    public VehicleTypeSpotAssignmentStrategy(List<Floor> floors) {
        this.floors = floors;
    }

    @Override
    public ParkingSpot getParkingSpot(Vehicle vehicle) {
        for(Floor floor: this.floors) {
            ParkingSpot ps = floor.getAvailableSpot(vehicle.getSpotType());
            if(ps != null) {
                return ps;
            }
        }

        return null;
    }
}
