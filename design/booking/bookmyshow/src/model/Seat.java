package design.booking.bookmyshow.src.model;

public class Seat {
    private int id;
    private String seatNumber;
    private SeatType seatType;

    public Seat(int id, String seatNumber, SeatType seatType) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public int getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
