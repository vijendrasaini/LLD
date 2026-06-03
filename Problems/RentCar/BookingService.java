package Problems.RentCar;

import Problems.RentCar.Enums.VehicleStatus;
import Problems.RentCar.Models.Booking;
import Problems.RentCar.Models.Vehicle;
import Problems.RentCar.Repository.BookingRepository;
import Problems.RentCar.Repository.UserProfileRepository;
import Problems.RentCar.Repository.VehicleRepository;
import Problems.RentCar.utils.Exceptions.RecordNotFoundExecption;

public class BookingService {
    private static final BookingService INSTANCE = new BookingService();
    private static final UserProfileRepository userProfileRepository = UserProfileRepository.getInstance();
    private static final VehicleRepository vehicileRepository = VehicleRepository.getInstance();
    private static final BookingRepository bookingRepository = BookingRepository.getInstance();
    private BookingService() {}
    public static BookingService getInstance() {
        return INSTANCE;
    }
    
    public int bookVehicle(int vehicleId, int guestId) throws RecordNotFoundExecption{

        Vehicle vehicle = vehicileRepository.getById(vehicleId);
        if(vehicle == null) {
            throw new RecordNotFoundExecption("Vehicle not found Vehicle ID : ");
        }

        vehicle.setStatus(VehicleStatus.BOOKED);
        vehicileRepository.save(vehicle);

        Booking booking = new Booking(vehicleId, guestId);
        bookingRepository.save(booking);
        return booking.id();
    }
}
