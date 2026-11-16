package model;

import enums.ParkingSpotType;

public class CarVehicle extends Vehicle{
    public CarVehicle(String number) {
        super.vehicleNumber = number;
        super.setSpotType(ParkingSpotType.COMPACT_SPOT);
    }
}
