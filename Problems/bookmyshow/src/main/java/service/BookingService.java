package service;

import enums.BookingStatus;
import enums.PaymentStatus;
import exception.PaymentFailedForBooking;
import exception.SeatNotAvailable;
import model.Booking;
import model.Seat;
import model.Show;
import model.ShowSeat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookingService {
    public Booking bookSeats(int userId, List<ShowSeat> showSeatList) throws PaymentFailedForBooking {
        showSeatList = new ArrayList<>(showSeatList);

        // sorting to avoid starvation in case of same seat is booked at the same time
        showSeatList.sort(Comparator.comparing(ShowSeat::getId));
        for(ShowSeat seat: showSeatList) {
            seat.lock();
        }

        List<ShowSeat> reservedSeats = new ArrayList<>();
        try {
            for(ShowSeat seat: showSeatList) {
                if(!seat.tryReserve()) {
                    makeShowSeatsAvailable(reservedSeats);
                    throw new SeatNotAvailable("Seat is not available");
                }

                reservedSeats.add(seat);
            }
        } finally {
            for(ShowSeat seat: showSeatList) {
                seat.unlock();
            }
        }


        Booking booking = new Booking(showSeatList, userId);
        PaymentStatus paymentStatus = makePayment(booking);
        if(paymentStatus == PaymentStatus.FAILURE) {
            makeShowSeatsAvailable(showSeatList);
            throw new PaymentFailedForBooking("Payment failed");
        }

        for(ShowSeat seat: showSeatList) {
            seat.book();
        }

        booking.setStatus(BookingStatus.BOOKED);
        return booking;
    }

    private PaymentStatus makePayment(Booking booking) {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Thread Exception message : " + e.getMessage());
        }
        return PaymentStatus.SUCCESS;
    }

    private void makeShowSeatsAvailable(List<ShowSeat> showSeatList) {
        showSeatList.forEach(ShowSeat::makeAvailable);
    }
}
