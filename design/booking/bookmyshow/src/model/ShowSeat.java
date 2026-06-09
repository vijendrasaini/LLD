package design.booking.bookmyshow.src.model;

import java.util.concurrent.locks.ReentrantLock;

public class ShowSeat {
    private int id;
    private Seat seat;
    private SeatStatus seatStatus;
    private Show show;
    private String valideTill;
    private ReentrantLock reentrantLock;

    public ShowSeat(int id, Seat Seat, Show show) {
        this.id = id;
        this.seat = Seat;
        this.seatStatus = SeatStatus.FREE;
        this.show = show;
        this.reentrantLock = new ReentrantLock();
    }

    public int getId() {
        return id;
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

    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }
}
