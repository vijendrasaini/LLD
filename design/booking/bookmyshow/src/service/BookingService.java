package design.booking.bookmyshow.src.service;

import java.util.List;

import design.booking.bookmyshow.src.model.Show;
import design.booking.bookmyshow.src.model.ShowSeat;
import design.booking.bookmyshow.src.repository.InMememoryRepository;

public class BookingService {
    private InMememoryRepository<Show> showInMememoryRepository;
    private InMememoryRepository<ShowSeat> showSeatInMememoryRepository;
    public BookingService(InMememoryRepository<Show> showInMememoryRepository, InMememoryRepository<ShowSeat> showSeatInMememoryRepository) {
        this.showInMememoryRepository = showInMememoryRepository;
        this.showSeatInMememoryRepository = showSeatInMememoryRepository;
    }

    public boolean bookTicket(int userId, int showId, List<Integer> seatIds) {
        
        Show show = showInMememoryRepository.findById(showId);
        show.reserveSeats(seatIds, showSeatInMememoryRepository);
        return true;
    }
}
