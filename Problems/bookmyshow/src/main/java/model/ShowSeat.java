package model;

import enums.SeatStatus;
import exception.SeatNotAvailable;
import exception.TimeToBookPassedException;

import java.time.LocalDateTime;
import java.util.concurrent.locks.ReentrantLock;

public class ShowSeat {
    private int id;
    private Seat seat;
    private double price;
    private SeatStatus status = SeatStatus.AVAILABLE;
    private LocalDateTime bookedAt;
    private final ReentrantLock lock = new ReentrantLock();

    public ShowSeat(int id, Seat seat, double price) {
        this.id = id;
        this.seat = seat;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void book() {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime reservedTill = bookedAt.plusMinutes(10);
        if(current.isAfter(reservedTill)) {
            throw new TimeToBookPassedException("Time to book the seat is passed.");
        }

        status = SeatStatus.BOOKED;
        bookedAt = LocalDateTime.now();
    }

    public void makeAvailable() {
        status = SeatStatus.AVAILABLE;
        bookedAt = null;
    }

    @Override
    public String toString() {
        return "ShowSeat{" +
                "id=" + id +
                ", seat=" + seat.getName()+
                ", price=" + price +
                ", status=" + status +
                ", bookedAt=" + bookedAt +
                '}';
    }

    public void lock() {
        this.lock.lock();
    }

    public void unlock() {
        this.lock.unlock();
    }

    public boolean tryReserve() {
        if(status == SeatStatus.BOOKED) {
            return false;
        }

        if(status == SeatStatus.AVAILABLE || status == SeatStatus.RESERVED && LocalDateTime.now().isAfter(bookedAt.plusMinutes(10))) {
            this.status = SeatStatus.RESERVED;
            this.bookedAt = LocalDateTime.now();
            return true;
        }

        return false;
    }
}
