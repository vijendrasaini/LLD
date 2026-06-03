package Problems.RentCar.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Problems.RentCar.Models.VehicleDetails;

public class VehicleDetailRepository implements Repository<VehicleDetails> {
    private static final VehicleDetailRepository INSTANCE = new VehicleDetailRepository();
    private static Map<Integer, VehicleDetails> map = new HashMap<>();

    private VehicleDetailRepository() {}

    public static VehicleDetailRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(VehicleDetails entity) {
        map.put(entity.id(), entity);
    }

    @Override
    public VehicleDetails getById(int id) {
        return map.getOrDefault(id, null);
    }

    public List<VehicleDetails> getAll() {
        return map.values().stream().toList();
    }
}
