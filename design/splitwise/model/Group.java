package design.splitwise.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int id;
    private String name;
    private List<User> users = new ArrayList<>();
    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
