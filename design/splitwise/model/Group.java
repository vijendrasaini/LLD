package design.splitwise.model;

import java.util.List;

public class Group {
    private int id;
    private String name;
    private List<Integer> userIds;
    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addUser(int userId) {
        this.userIds.add(userId);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
