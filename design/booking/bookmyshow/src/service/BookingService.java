package design.booking.bookmyshow.src.service;

import java.util.List;

import design.booking.bookmyshow.src.model.Show;
import design.booking.bookmyshow.src.model.ShowSeat;
import design.booking.bookmyshow.src.model.User;

public class BookingService {
    public BookingService() {
    }

    public String bookTicket(User user, Show show, List<ShowSeat> showSeats) {
        return "Booked";
    }
}
