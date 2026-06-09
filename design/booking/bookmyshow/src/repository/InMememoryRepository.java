package design.booking.bookmyshow.src.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMememoryRepository<T> {
    private Map<Integer, T> db;
    private InMememoryRepository() {
        this.db = new HashMap<>();
    }

    public int insert(int id, T data ) {
        db.put(id, data);
        return id;
    }

    public T findById(int id) {
        return db.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(db.values());
    }
}
