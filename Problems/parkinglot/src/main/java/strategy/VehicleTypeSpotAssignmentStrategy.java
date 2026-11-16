package strategy;

import enums.ParkingSpotType;
import enums.VehicleType;
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
            ParkingSpot ps = floor.getAvailableSpot(getParkingSpotType(vehicle.getVehicleType()));
            if(ps != null) {
                return ps;
            }
        }

        return null;
    }

    ParkingSpotType getParkingSpotType(VehicleType vehicleType) {
        return switch (vehicleType) {
            case VehicleType.MOTORCYCLE -> ParkingSpotType.MOTORCYCLE_SPOT;
            case VehicleType.CAR -> ParkingSpotType.COMPACT_SPOT;
            default -> ParkingSpotType.LARGE_SPOT;
        };
    }
}
