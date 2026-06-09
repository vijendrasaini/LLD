package design.booking.bookmyshow.src;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.spi.ImageInputStreamSpi;

import Problems.RentCar.Repository.BookingRepository;
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
        for (Seat seat : seats) {
            showSeats.add(new ShowSeat(seat));
        }

        Show show = new Show(1, screen1, null, null, null, showSeats);

        User user = new User(1, "vijendra@gmail.com", "Vijendra");

        InMememoryRepository<Show> inMememoryRepository = new InMememoryRepository<>();
        BookingService bookingRepository = new BookingService(inMememoryRepository);
        List<Integer> seatIds = new ArrayList<>();
        seatIds.add(showSeats.get(0).getSeat().getId());
        seatIds.add(showSeats.get(1).getSeat().getId()); // 
        bookingRepository.bookTicket(user.getId(), show.getId(), seatIds);
    }    
}