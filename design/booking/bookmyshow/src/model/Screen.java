package design.booking.bookmyshow.src.model;

public class Screen {
    private int id;
    private Theatre theatre;
    private String name;

    public Screen(int id, Theatre theatre, String name) {
        this.id = id;
        this.theatre = theatre;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public String getName() {
        return name;
    }
}
