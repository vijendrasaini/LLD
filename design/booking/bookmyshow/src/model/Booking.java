package design.booking.bookmyshow.src.model;

import java.util.List;

public class Booking {
    private int id;
    private int bookedBy;
    private int showId;
    private List<Integer> seatIds;
    private BookingStatus bookingStatus;
    private String createdAt;
    private String updatedAt;
    private static int counter = 0;

    public Booking(int bookedBy, int showId, List<Integer> seatIds) {
        this.id = ++counter; // just doing it to mock unique booking id. I know it's not good and not done in this way. 
        this.bookedBy = bookedBy;
        this.showId = showId;
        this.seatIds = seatIds;
        this.bookingStatus = BookingStatus.CREATED;
        this.createdAt = "now()";
        this.updatedAt = null;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getShowId() {
        return showId;
    }

    public List<Integer> getSeatIds() {
        return seatIds;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public int getId() {
        return id;
    }
}
