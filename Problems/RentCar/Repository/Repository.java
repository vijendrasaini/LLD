package Problems.RentCar.Repository;

public interface Repository<T> {
    void save(T entity);
    T getById(int id);
}
