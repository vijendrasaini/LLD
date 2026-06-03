package Problems.RentCar.Models;

import Problems.RentCar.Enums.VehicleType;
import Problems.RentCar.utils.Constants;

public class VehicleDetails extends Model{
    private VehicleType vehicleType;
    private int registrationYear;
    private int mileage;
    private String brand;
    private String vehicleNumber;
    public VehicleDetails() {
        super(Constants.ENTITY_VEHICLE_DETAILS);
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    public int getRegistrationYear() {
        return registrationYear;
    }
    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String toString() {
        return "VehicleDetails {" +
                "id='" + id() + '\'' +
                ", vehicleType=" + vehicleType +
                ", brand='" + brand + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", registrationYear=" + registrationYear +
                ", mileage=" + mileage + " km" +
                '}';
    }
}
