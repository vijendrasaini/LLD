package model;

import enums.VehicleType;

public abstract class Vehicle {
    private VehicleType vehicleType;
    String vehicleNumber;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
