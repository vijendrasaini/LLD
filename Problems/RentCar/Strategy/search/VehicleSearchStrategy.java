package Problems.RentCar.Strategy.search;

import java.util.List;

import Problems.RentCar.Models.Vehicle;
import Problems.RentCar.Repository.VehicleRepository;

public class VehicleSearchStrategy implements SearchStrategy<Vehicle> {
    @Override
    public List<Vehicle> search(String query) {
        return VehicleRepository.getInstance().getByQuery(query);
    }
    
}
