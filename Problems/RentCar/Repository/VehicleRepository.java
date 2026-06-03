package Problems.RentCar.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Problems.RentCar.Enums.VehicleStatus;
import Problems.RentCar.Models.Address;
import Problems.RentCar.Models.Vehicle;
import Problems.RentCar.Models.VehicleDetails;

public class VehicleRepository implements Repository<Vehicle> {
    private static final VehicleRepository INSTANCE = new VehicleRepository();
    private static Map<Integer, Vehicle> map = new HashMap<>();

    private VehicleRepository() {}

    public static VehicleRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Vehicle entity) {
        map.put(entity.id(), entity);
    }

    @Override
    public Vehicle getById(int id) {
        return map.getOrDefault(id, null);
    }

    public List<Vehicle> getAll() {
        return map.values().stream().toList();
    }

    public List<Vehicle> getByQuery(String query) {
        return map.values().stream().filter(vehicle -> {
            Address address = AddressRepository.getInstance().getById(vehicle.getAddressId());
            VehicleDetails vehicleDetails = VehicleDetailRepository.getInstance().getById(vehicle.getVehicleDetailsId());
            boolean found = vehicleDetails.getBrand().equalsIgnoreCase(query) || 
                vehicleDetails.getVehicleNumber().equalsIgnoreCase(query) ||
                address.getCity().equalsIgnoreCase(query) ||
                address.getSector().equalsIgnoreCase(query) ||
                address.getState().equalsIgnoreCase(query) || vehicle.getStatus() == VehicleStatus.AVAILABLE;
            
            return found;

        }).toList();
    }
}
