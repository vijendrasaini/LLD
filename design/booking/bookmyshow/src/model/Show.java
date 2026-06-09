package design.booking.bookmyshow.src.model;

import java.util.List;

public class Show {
    private Screen screen;
    private String date;
    private String startsAt;
    private String endsAt;
    private List<ShowSeat> showSeats;

    public Show(Screen screen, String date, String startsAt, String endsAt, List<ShowSeat> showSeats) {
        this.screen = screen;
        this.date = date;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.showSeats = showSeats;
    }
}
