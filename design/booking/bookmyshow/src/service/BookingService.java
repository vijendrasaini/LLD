package design.booking.bookmyshow.src.service;

import java.util.List;

import design.booking.bookmyshow.src.model.Show;
import design.booking.bookmyshow.src.model.ShowSeat;
import design.booking.bookmyshow.src.model.User;
import design.booking.bookmyshow.src.repository.InMememoryRepository;

public class BookingService {
    private InMememoryRepository<Show> showInMememoryRepository;
    public BookingService(InMememoryRepository<Show> showInMememoryRepository) {
        this.showInMememoryRepository = showInMememoryRepository;
    }

    public boolean bookTicket(int userId, int showId, List<Integer> seatIds) {

        Show show = showInMememoryRepository.findById(showId);
        show.reserveSeats(seatIds);
        // payment logic goes here.
        return true;
    }
}
