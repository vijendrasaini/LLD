package Problems.RentCar.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Problems.RentCar.Models.Booking;
public class BookingRepository implements Repository<Booking> {
    private static final BookingRepository INSTANCE = new BookingRepository();
    private static Map<Integer, Booking> map = new HashMap<>();

    private BookingRepository() {}

    public static BookingRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(Booking entity) {
        map.put(entity.id(), entity);
    }

    @Override
    public Booking getById(int id) {
        return map.getOrDefault(id, null);
    }

    public List<Booking> getAll() {
        return map.values().stream().toList();
    }
}
