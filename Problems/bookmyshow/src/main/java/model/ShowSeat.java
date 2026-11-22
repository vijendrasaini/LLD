package model;

import enums.SeatStatus;
import exception.SeatNotAvailable;
import exception.TimeToBookPassedException;

import java.time.LocalDateTime;

public class ShowSeat {
    private int id;
    private Seat seat;
    private double price;
    private SeatStatus status = SeatStatus.AVAILABLE;
    private LocalDateTime bookedAt;

    public ShowSeat(int id, Seat seat, double price) {
        this.id = id;
        this.seat = seat;
        this.price = price;
    }

    public synchronized void reserve() {
        if(this.status != SeatStatus.AVAILABLE) {
            throw new SeatNotAvailable("Not available");
        }

        LocalDateTime current = LocalDateTime.now();
        LocalDateTime reservedTill = bookedAt.plusMinutes(10);
        if(!current.isAfter(reservedTill)) {
            throw new SeatNotAvailable("Not available");
        }

        status = SeatStatus.RESERVED;
        bookedAt = LocalDateTime.now();
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
}
