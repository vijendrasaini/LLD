package design.booking.bookmyshow.src.model;

public class Seat {
    private int it;
    private String seatNumber;
    private SeatType seatType;

    public Seat(int it, String seatNumber, SeatType seatType) {
        this.it = it;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public int getIt() {
        return it;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
