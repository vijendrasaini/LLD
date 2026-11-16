package model;

import enums.ParkingSpotType;

public abstract class Vehicle {
    private ParkingSpotType spotType;
    String vehicleNumber;

    public ParkingSpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(ParkingSpotType parkingSpotType) {
        this.spotType = parkingSpotType;
    }
}
