package design.splitwise.model;

import java.time.LocalDateTime;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private List<Integer> userIds;
    private LocalDateTime createdAt;
    private int createdBy;
    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addUser(int userId) {
        this.userIds.add(userId);
    }

    public int getId() {
        return id;
    }
}
