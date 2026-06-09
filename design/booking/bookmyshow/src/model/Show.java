package design.booking.bookmyshow.src.model;

import java.util.List;

import design.booking.bookmyshow.src.repository.InMememoryRepository;

public class Show {
    private int id;
    private Screen screen;
    private String date;
    private String startsAt;
    private String endsAt;
    private List<ShowSeat> showSeats;

    public Show(int id, Screen screen, String date, String startsAt, String endsAt, List<ShowSeat> showSeats) {
        this.id = id;
        this.screen = screen;
        this.date = date;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
        this.showSeats = showSeats;
    }

    public boolean reserveSeats(List<Integer> seatIds) {
        InMememoryRepository<ShowSeat> showSeatInMememoryRepository = new InMememoryRepository<>();

        showSeatInMememoryRepository.findAll();

        List<ShowSeat> showSeats = showSeatInMememoryRepository.findAll().stream()
            .filter(showSeat -> showSeat.getShow().getId() == this.id)
            .filter(showSeat -> showSeat.getSeatStatus() == SeatStatus.FREE)
            .filter(showSeat -> seatIds.contains(showSeat.getSeat().getId()))
            .toList();

        if(showSeats.size() != seatIds.size()) {
            throw new RuntimeException("Can't book all seats");
        }

        // if the seats are free than let's reserve them for 10 mins
        String currentTime = "current time"; // I will learn java date time handling than change it ( just now desing the behaviour )
        for (ShowSeat showSeat : showSeats) {
            showSeat.setValideTill(currentTime + "+ 10 mins");
        }

        // save showSeats to the repository. 
        // since object is there show it not required for in membory.

        return true;
    }

    public int getId() {
        return id;
    }
}
