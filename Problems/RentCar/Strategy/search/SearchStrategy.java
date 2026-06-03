package Problems.RentCar.Strategy.search;

import java.util.List;


public interface SearchStrategy<T> {
    public List<T> search(String query);
}
