package Problems.RentCar;

import Problems.RentCar.Enums.ProfileType;
import Problems.RentCar.Models.UserProfile;
import Problems.RentCar.Repository.UserProfileRepository;

public class UserProfileService {
    private static final UserProfileService INSTANCE = new UserProfileService();
    private static final UserProfileRepository userProfileRepository = UserProfileRepository.getInstance();
    private UserProfileService() {}
    public static UserProfileService getInstance() {
        return INSTANCE;
    }
    
    public int addUser(String name, ProfileType profileType) {

        UserProfile userProfile = new UserProfile(profileType);
        userProfile.setName(name);

        userProfileRepository.save(userProfile);
        return userProfile.id();
    }

    public UserProfile getProfile(int id) {
        return userProfileRepository.getById(id);
    }

    public void printAllProfiles() {
        for (UserProfile vehicle : userProfileRepository.getAll()) {
            System.out.println(vehicle);
        }
    }
}
