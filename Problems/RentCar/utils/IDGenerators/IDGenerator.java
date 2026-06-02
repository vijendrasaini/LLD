package Problems.RentCar.utils.IDGenerators;

public interface IDGenerator<T> {
    T next(String entityName);
}
