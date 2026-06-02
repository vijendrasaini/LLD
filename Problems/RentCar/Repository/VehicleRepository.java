package Problems.RentCar.Repository;

import java.util.HashMap;
import java.util.Map;

import Problems.RentCar.Models.Vehicle;

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
}
