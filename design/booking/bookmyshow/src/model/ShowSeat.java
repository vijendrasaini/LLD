package design.booking.bookmyshow.src.model;

public class ShowSeat {
    private Seat seat;
    private SeatStatus seatStatus;

    public ShowSeat(Seat Seat) {
        seat = Seat;
        this.seatStatus = SeatStatus.FREE;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
