package design.booking.bookmyshow.src.service;

import java.util.List;
import java.util.Random;

import design.booking.bookmyshow.src.model.Booking;
import design.booking.bookmyshow.src.model.BookingStatus;
import design.booking.bookmyshow.src.model.SeatStatus;
import design.booking.bookmyshow.src.model.Show;
import design.booking.bookmyshow.src.model.ShowSeat;
import design.booking.bookmyshow.src.repository.InMememoryRepository;

public class BookingService {
    private InMememoryRepository<Show> showInMememoryRepository;
    private InMememoryRepository<ShowSeat> showSeatInMememoryRepository;
    private InMememoryRepository<Booking> bookingInMememoryRepository;
    public BookingService(InMememoryRepository<Show> showInMememoryRepository, InMememoryRepository<ShowSeat> showSeatInMememoryRepository, InMememoryRepository<Booking> bookingInMememoryRepository) {
        this.showInMememoryRepository = showInMememoryRepository;
        this.showSeatInMememoryRepository = showSeatInMememoryRepository;
        this.bookingInMememoryRepository = bookingInMememoryRepository;
    }

    public boolean bookTicket(int userId, int showId, List<Integer> seatIds) {
        
        Show show = showInMememoryRepository.findById(showId);
        Booking booking = new Booking(userId, showId, seatIds);

        
        List<ShowSeat> showSeats = showSeatInMememoryRepository.findAll().stream()
            .filter(showSeat -> showSeat.getSeatStatus() == SeatStatus.FREE)
            .filter(showSeat -> seatIds.contains(showSeat.getSeat().getId()))
            .toList();
            
        if(showSeats.size() != seatIds.size()) {
            throw new RuntimeException("Can't book all seats");
        }
            
        // send ids in sorted order here first to stop dead lock condition here.
        show.reserveSeats(showSeats, userId);

        // let's create a booking and set it's status to reserved. assuming that seats are reserved above to it.
        booking.setBookingStatus(BookingStatus.RESERVED);
        bookingInMememoryRepository.insert(booking.getId(), booking);
        return true;
    }

    public void freeExpiredReservedBooking() {
        for(Show show : showInMememoryRepository.findAll()) {
            show.freeExpiredReservedBooking(show);
        }
    }

    public Show getShow(int id) {
        return showInMememoryRepository.findById(id);
    }

    public void makePayment(int bookingId) {
        // let's assume that payment is bieng made under the expirty time

        Booking booking = bookingInMememoryRepository.findById(bookingId);
        Show show = showInMememoryRepository.findById(booking.getShowId());

        show.bookSeats(booking.getSeatIds());
        booking.setBookingStatus(BookingStatus.BOOKED);
    }
}
