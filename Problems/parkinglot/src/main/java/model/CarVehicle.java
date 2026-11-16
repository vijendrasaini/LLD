package model;

import enums.ParkingSpotType;
import enums.VehicleType;

public class CarVehicle extends Vehicle{
    public CarVehicle(String number) {
        super.vehicleNumber = number;
        super.setVehicleType(VehicleType.CAR);
    }
}
