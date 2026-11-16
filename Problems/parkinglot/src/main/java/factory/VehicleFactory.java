package factory;

import model.Vehicle;

public abstract class VehicleFactory {
    public abstract Vehicle createVehicle(String vehicleNumber);
}
