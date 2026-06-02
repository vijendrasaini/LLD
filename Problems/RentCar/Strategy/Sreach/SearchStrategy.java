package Problems.RentCar.Strategy.Sreach;

import java.util.List;


public interface SearchStrategy<T> {
    public List<T> search(String query);
}
