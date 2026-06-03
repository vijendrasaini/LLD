package Problems.RentCar;

import java.util.List;


import Problems.RentCar.Enums.ProfileType;
import Problems.RentCar.Enums.VehicleType;
import Problems.RentCar.Models.Address;
import Problems.RentCar.Models.UserProfile;
import Problems.RentCar.Models.Vehicle;
import Problems.RentCar.Models.VehicleDetails;
import Problems.RentCar.Repository.AddressRepository;
import Problems.RentCar.Repository.VehicleDetailRepository;
import Problems.RentCar.Strategy.Sreach.VehicleSearchStrategy;
import Problems.RentCar.utils.Exceptions.RecordNotFoundExecption;

public class Main {
    public static void main(String[] args) {
        UserProfileService.getInstance().addUser("Guest-1", ProfileType.GUEST);
        int hostId = UserProfileService.getInstance().addUser("Host-1", ProfileType.HOST);

        VehicleDetails vehicleDetails = new VehicleDetails();
        vehicleDetails.setBrand("Tesla");
        vehicleDetails.setMileage(30);
        vehicleDetails.setRegistrationYear(2010);
        vehicleDetails.setVehicleNumber("RJ18XY1234");
        vehicleDetails.setVehicleType(VehicleType.DIESEL);
        VehicleDetailRepository.getInstance().save(vehicleDetails);


        Address address = new Address();
        address.setFlatNumber("1/2");
        address.setSector("HSR layout");
        address.setCity("Bangalore");
        address.setState("Karnatka");
        AddressRepository.getInstance().save(address);

        VehicleService.getInstance().addVehcile(address.id(), vehicleDetails.id(), hostId, VehicleType.ELECTRIC);
        
        vehicleDetails = new VehicleDetails();
        vehicleDetails.setBrand("Tata");
        vehicleDetails.setMileage(30);
        vehicleDetails.setRegistrationYear(2010);
        vehicleDetails.setVehicleNumber("RJ18XY1234");
        vehicleDetails.setVehicleType(VehicleType.DIESEL);
        VehicleDetailRepository.getInstance().save(vehicleDetails);


        address = new Address();
        address.setFlatNumber("26/11");
        address.setSector("Mansrover");
        address.setCity("Jaipur");
        address.setState("Rajasthan");
        AddressRepository.getInstance().save(address);

        VehicleService.getInstance().addVehcile(address.id(), vehicleDetails.id(), hostId, VehicleType.PETROL);

        // VehicleService.getInstance().printAllVehicles();

        // performing search
        SearchService<Vehicle> vehicleSearchServic = new SearchService<>(new VehicleSearchStrategy());
        List<Vehicle> list = vehicleSearchServic.search("karnatka");
        if ( list.size() > 0 )  {
            // user wants to book first car for self drive
            Vehicle selectedVehicle = list.getFirst();

            try {
                int guestId = 1;
                UserProfile userProfile = UserProfileService.getInstance().getProfile(guestId); // let's user with ID wants to book;
                System.out.println("User : " + userProfile.getName() + " is making booking ...");
                int bookingId = BookingService.getInstance().bookVehicle(selectedVehicle.id(), guestId);
                System.out.println("Your booking Id is : " + bookingId);

                // let's see the status after booking ...
                System.out.println(VehicleService.getInstance().getVehicle(selectedVehicle.id()));

                // Here after some time user can make the payment ( for that Strategy design pattern could be used to select the method)
                // Once payment is success than Guest can rate to Host vehicle and to Host as well. 
                // Host can also rate to guest.
                // Vehicle status will be changed to Availble or ( free to be booked by anyone now )
                // so this is overall going to be the flow
            } catch (RecordNotFoundExecption e) {
                System.out.println("Invalid vehcile ID. Vehicle does exist with the provided id.");
            }
        }

        list.forEach(System.out::println);
    }
}
