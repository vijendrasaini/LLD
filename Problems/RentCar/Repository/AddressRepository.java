package Problems.RentCar.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Problems.RentCar.Models.Address;

public class AddressRepository implements Repository<Address> {
    private static final AddressRepository INSTANCE = new AddressRepository();
    private static Map<Integer, Address> map = new HashMap<>();

    private AddressRepository() {}

    public static AddressRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Address entity) {
        map.put(entity.id(), entity);
    }

    @Override
    public Address getById(int id) {
        return map.getOrDefault(id, null);
    }

    public List<Address> getAll() {
        return map.values().stream().toList();
    }
}
