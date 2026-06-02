package Problems.RentCar;

import java.util.List;

import Problems.RentCar.Strategy.Sreach.SearchStrategy;

public class SearchService<T> {
    private SearchStrategy<T> searchStrategy;

    public SearchService(SearchStrategy<T> searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public List<T> search(String query) {
        if(query == null || query.trim().length() == 0) {
            return List.of();
        }

        return searchStrategy.search(query);
    }
}
