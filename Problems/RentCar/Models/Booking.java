package Problems.RentCar.Models;
import Problems.RentCar.utils.Constants;

public class Booking extends Model {
    private int vehicleId;
    private int bookedBy;

    public Booking(int vehicleId, int bookedBy) {
        super(Constants.ENTITY_BOOKING);
        this.vehicleId = vehicleId;
        this.bookedBy = bookedBy;
    }

    public int getBookedBy() {
        return bookedBy;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    @Override
    public String toString() {
        return "Booking {" +
                "id='" + id() +
                ", Booked By ='" + bookedBy + '\'' +
                ", Vehicle Id=" + vehicleId +
                '}';
    }
}