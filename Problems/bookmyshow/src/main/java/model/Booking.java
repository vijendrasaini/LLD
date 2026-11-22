package model;

import enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Booking {
    private String id;
    private int bookedBy;
    private BookingStatus status = BookingStatus.CREATED;
    private List<ShowSeat> showSeats;

    private LocalDateTime createdAt;
    public Booking(List<ShowSeat> showSeats, int bookedBy) {
        id = UUID.randomUUID().toString();
        this.showSeats = showSeats;
        this.createdAt = LocalDateTime.now();
        this.bookedBy = bookedBy;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", bookedBy=" + bookedBy +
                ", status=" + status +
                ", showSeats=" + showSeats +
                ", createdAt=" + createdAt +
                '}';
    }
}
