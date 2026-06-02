package Problems.RentCar.Models;

import Problems.RentCar.Enums.VehicleType;

public class VehicleDetails {
    private int id;
    private VehicleType vehicleType;
    private int registrationYear;
    private int mileage;
    private String brand;
    private String vehicleNumber;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
}
