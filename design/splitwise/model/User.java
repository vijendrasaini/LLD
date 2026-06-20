package design.splitwise.model;

public class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "[ID : %d, Name : %s]".formatted(this.id, this.name);
    }
}
