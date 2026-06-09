package design.booking.bookmyshow.src;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.spi.ImageInputStreamSpi;

import Problems.RentCar.Repository.BookingRepository;
import design.booking.bookmyshow.src.model.Booking;
import design.booking.bookmyshow.src.model.Screen;
import design.booking.bookmyshow.src.model.Seat;
import design.booking.bookmyshow.src.model.SeatType;
import design.booking.bookmyshow.src.model.Show;
import design.booking.bookmyshow.src.model.ShowSeat;
import design.booking.bookmyshow.src.model.Theatre;
import design.booking.bookmyshow.src.model.User;
import design.booking.bookmyshow.src.repository.InMememoryRepository;
import design.booking.bookmyshow.src.service.BookingService;

public class Main {
    public static void main(String[] args) {
        Theatre theatre = new Theatre(1, "RajMandir");

        Screen screen1 = new Screen(1, theatre, "Hindi Movies");

        Seat seat1 = new Seat(1, "S1-A", SeatType.GOLD);
        Seat seat2 = new Seat(2, "S1-B", SeatType.SILVER);
        Seat seat3 = new Seat(3, "S1-C", SeatType.SILVER);

        List<Seat> seats = List.of(seat1, seat2, seat3);
        List<ShowSeat> showSeats = new ArrayList<>();

        InMememoryRepository<Show> inMememoryRepository = new InMememoryRepository<>();
        InMememoryRepository<ShowSeat> showSeatInMememoryRepository = new InMememoryRepository<>();
        InMememoryRepository<Booking> bookingInMememoryRepository = new InMememoryRepository<>();
        

        for (Seat seat : seats) {
            showSeats.add(new ShowSeat(seat.getId(), seat));
        }

        for (ShowSeat showSeat : showSeats) {
            showSeatInMememoryRepository.insert(showSeat.getId(), showSeat);
        }

        Show show = new Show(1, screen1, "current date", "start date", "end date", showSeats);

        inMememoryRepository.insert(show.getId(), show);
        User user = new User(1, "vijendra@gmail.com", "Vijendra");
        User user2 = new User(2, "shimbhu@gmail.com", "Shimbhu");

        BookingService bookingService = new BookingService(inMememoryRepository, showSeatInMememoryRepository, bookingInMememoryRepository);
        List<Integer> seatIds = new ArrayList<>();
        seatIds.add(showSeats.get(0).getSeat().getId());
        seatIds.add(showSeats.get(1).getSeat().getId());


        bookingService.bookTicket(user.getId(), show.getId(), seatIds);
        try {
            System.out.println("Seats : " + seatIds + " have been booked reserved please pay the amount.");
        } catch (Exception e) {
            System.out.println(" some errro while booking ...");
            System.out.println(e.getMessage());
        }

        // now let's see what now user 2 is trying to book the same bookings after the expiry time so user 2 should be able
        // we will free the show seats.
        // bookingService.bookTicket(user2.getId(), show.getId(), seatIds); // thows exceptin as expected since bookings are still in resserved status
        
        // let's free them
        bookingService.freeExpiredReservedBooking();

        // let's try now
        bookingService.bookTicket(user2.getId(), show.getId(), seatIds); // books now

        Show show2 = bookingService.getShow(show.getId()); 
        System.out.println(show2);
        for(ShowSeat showSeat : show2.getShowSeats()) {
            System.out.println(showSeat.getSeatStatus());
        }

        // yes now earlier reserved seat are not reserved by user 2

        Booking booking = bookingInMememoryRepository.findById(1);// let's the staus of first booking.
        bookingService.makePayment(booking.getId()); // should be booked if getting done with in time
        
        System.out.println(booking.getBookingStatus()); // should show booked
    }    
}