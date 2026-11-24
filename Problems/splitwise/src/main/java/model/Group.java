package model;

import java.util.*;

public class Group {
    private int id;
    private String name;
    private List<User> users;
    private Map<User, Map<User, Double>> balance;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = new HashMap<>();
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
        balance.put(user, new HashMap<>());
    }

    public Map<User, Double> getUserBalance(User user) {
        if(!this.balance.containsKey(user)) {
            this.balance.put(user, new HashMap<>());
        }

        return this.balance.get(user);
    }

    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    public int getUsersCount() {
        return this.users.size();
    }
}
