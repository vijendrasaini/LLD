package Problems.RentCar.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Problems.RentCar.Models.UserProfile;

public class UserProfileRepository implements Repository<UserProfile> {
    private static final UserProfileRepository INSTANCE = new UserProfileRepository();
    private static Map<Integer, UserProfile> map = new HashMap<>();

    private UserProfileRepository() {}

    public static UserProfileRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(UserProfile entity) {
        map.put(entity.id(), entity);
    }

    @Override
    public UserProfile getById(int id) {
        return map.getOrDefault(id, null);
    }

    public List<UserProfile> getAll() {
        return map.values().stream().toList();
    }
}
