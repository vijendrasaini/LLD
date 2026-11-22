package model;

import java.time.LocalDateTime;
import java.util.List;

public class Show {
    private int id;
    private Movie movie;
    private List<ShowSeat> seats;
    private LocalDateTime startsAt;
    private LocalDateTime endsAt;

    public Show(int id, Movie movie, List<ShowSeat> seats, LocalDateTime startsAt, LocalDateTime endsAt) {
        this.id = id;
        this.movie = movie;
        this.seats = seats;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }
}
