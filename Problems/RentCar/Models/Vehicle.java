package Problems.RentCar.Models;

import Problems.RentCar.utils.Constants;

public class Vehicle extends Model{
    private int vehicleDetailsId;
    private int addressId;

    public Vehicle() {
        super(Constants.ENTITY_VEHICLE);
    }

    public void setVehicleDetailsId(int vehicleDetailsId) {
        this.vehicleDetailsId = vehicleDetailsId;
    }
    
    public int getVehicleDetailsId() {
        return vehicleDetailsId;
    }
    
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }    

    public int getAddressId() {
        return addressId;
    }
}
