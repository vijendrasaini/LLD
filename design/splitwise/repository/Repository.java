package design.splitwise.repository;

import java.util.List;

public interface Repository<T> {
    int add(T data);
    T getById(int i);
    List<T> getAll();
    void delete(int id);
    void updateById(int id, T data);
}
