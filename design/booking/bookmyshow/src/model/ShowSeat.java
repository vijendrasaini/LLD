package design.booking.bookmyshow.src.model;

import java.util.concurrent.locks.ReentrantLock;

public class ShowSeat {
    private int id;
    private Seat seat;
    private SeatStatus seatStatus;
    private String valideTill;
    private ReentrantLock reentrantLock;
    private int reservedBy;

    public ShowSeat(int id, Seat Seat) {
        this.id = id;
        this.seat = Seat;
        this.seatStatus = SeatStatus.FREE;
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

    public void setReservedBy(int reservedBy) {
        this.reservedBy = reservedBy;
    }

    public int getReservedBy() {
        return reservedBy;
    }
}
