package model;

public class Seat {
    private int id;
    private String name;

    public Seat(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
