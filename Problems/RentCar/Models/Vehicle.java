package Problems.RentCar.Models;

import Problems.RentCar.Enums.VehicleStatus;
import Problems.RentCar.Repository.AddressRepository;
import Problems.RentCar.Repository.UserProfileRepository;
import Problems.RentCar.Repository.VehicleDetailRepository;
import Problems.RentCar.utils.Constants;
import java.util.Objects;

public class Vehicle extends Model {
    private int vehicleDetailsId;
    private int addressId;
    private int hostId;
    private VehicleStatus status;

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

    public void setHostId(int hostId) {
        this.hostId = hostId;
    }

    public int getAddressId() {
        return addressId;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        VehicleDetails vehicleDetails = VehicleDetailRepository.getInstance().getById(getVehicleDetailsId());
        Address address = AddressRepository.getInstance().getById(getAddressId());
        UserProfile userProfile = UserProfileRepository.getInstance().getById(hostId);

        return "Vehicle Status : " + Objects.toString(status, "UNKNOWN") + "\n'" +
                "Host : " + Objects.toString(userProfile, "unknown host") + "\n'" +
                "Address : " + Objects.toString(address, "unknown address") + "\n'" +
                "VehicleDetails : " + Objects.toString(vehicleDetails, "unknown details") + "\n'";
    }
}
