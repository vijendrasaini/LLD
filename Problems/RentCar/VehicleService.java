package Problems.RentCar;

import Problems.RentCar.Enums.VehicleType;
import Problems.RentCar.Models.Vehicle;
import Problems.RentCar.Models.VehicleDetails;
import Problems.RentCar.Repository.VehicleDetailRepository;
import Problems.RentCar.Repository.VehicleRepository;

public class VehicleService {
    private static final VehicleService INSTANCE = new VehicleService();
    private static final VehicleRepository vehicileRepository = VehicleRepository.getInstance();
    private static final VehicleDetailRepository vehicleDetailRepository = VehicleDetailRepository.getInstance();
    private VehicleService() {}
    public static VehicleService getInstance() {
        return INSTANCE;
    }
    
    public int addVehcile(int addressId, int vehicleDetailsId, int userId, VehicleType vehicleType) {

        Vehicle vehicle = new Vehicle();

        vehicle.setAddressId(addressId);
        vehicle.setVehicleDetailsId(vehicleDetailsId);
        vehicle.setHostId(vehicleDetailsId);

        vehicileRepository.save(vehicle);
        return vehicle.id();
    }

    public Vehicle getVehicle(int id) {
        return vehicileRepository.getById(id);
    }

    public VehicleDetails getVehicleDetail(int id) {
        return vehicleDetailRepository.getById(id);
    }

    public void printAllVehicles() {
        for (Vehicle vehicle : vehicileRepository.getAll()) {
            System.out.println(vehicle);
        }
    }
}
