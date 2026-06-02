package Problems.RentCar.Models;

import Problems.RentCar.Enums.ProfileType;

public class UserProfile {
    private int id;
    private String name;
    private ProfileType profileType;
    public UserProfile(int id, String name, ProfileType profileType) {
        this.id = id;
        this.name = name;
        this.profileType = profileType;
    }
}