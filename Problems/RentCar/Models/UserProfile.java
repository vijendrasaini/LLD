package Problems.RentCar.Models;

import Problems.RentCar.Enums.ProfileType;
import Problems.RentCar.utils.Constants;

public class UserProfile extends Model {
    private String name;
    private ProfileType profileType;

    public UserProfile(ProfileType profileType) {
        super(Constants.ENTITY_USERPROFILE);
        this.profileType = profileType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ProfileType getProfileType() {
        return profileType;
    }

    @Override
    public String toString() {
        return "UserProfile {" +
                "id='" + id() +
                ", name='" + name + '\'' +
                ", profileType=" + profileType +
                '}';
    }
}