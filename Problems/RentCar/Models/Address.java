package Problems.RentCar.Models;

import Problems.RentCar.utils.Constants;

public class Address extends Model {
    private String flatNumber;
    private String sector;
    private String city;
    private String state;
    public Address() {
        super(Constants.ENTITY_ADDRESS);
    }

    public String getFlatNumber() {
        return flatNumber;
    }
    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }
    public String getSector() {
        return sector;
    }
    public void setSector(String sector) {
        this.sector = sector;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address {" +
                "baseInfo=" + id() +
                ", flatNumber='" + flatNumber + '\'' +
                ", sector='" + sector + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
