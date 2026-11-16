package factory;

import model.CarVehicle;
import model.Vehicle;

public class CarVehicleFactory extends VehicleFactory {
    @Override
    public Vehicle createVehicle(String vehicleNumber) {
        return new CarVehicle(vehicleNumber);
    }
}
