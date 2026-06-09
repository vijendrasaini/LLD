package design.booking.bookmyshow.src.model;

public class ShowSeat {
    private Seat seat;
    private SeatStatus seatStatus;
    private Show show;
    private String valideTill;

    public ShowSeat(Seat Seat) {
        seat = Seat;
        this.seatStatus = SeatStatus.FREE;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public String getValideTill() {
        return valideTill;
    }

    public void setValideTill(String valideTill) {
        this.valideTill = valideTill;
    }
}
