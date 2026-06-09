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

    public Show(int id, Screen screen, String date, String startsAt, String endsAt) {
        this.id = id;
        this.screen = screen;
        this.date = date;
        this.startsAt = startsAt;
        this.endsAt = endsAt;
    }

    public boolean reserveSeats(List<Integer> seatIds, InMememoryRepository<ShowSeat> showSeatInMememoryRepository) {
        List<ShowSeat> showSeats = showSeatInMememoryRepository.findAll().stream()
            // .peek((showSeat -> System.out.println(showSeat.getId())))
            .filter(showSeat -> showSeat.getShow().getId() == this.id)
            .filter(showSeat -> showSeat.getSeatStatus() == SeatStatus.FREE)
            .filter(showSeat -> seatIds.contains(showSeat.getSeat().getId()))
            .toList();

            // sort here first to stop dead lock condition here.
            
        if(showSeats.size() != seatIds.size()) {
            throw new RuntimeException("Can't book all seats");
        }

        // if the seats are free than let's reserve them for 10 mins

        // this seats are contested resources so we will lock these. ( No sure how technallity do it may be using atomic referance )
        String currentTime = "current time"; // I will learn java date time handling than change it ( just now desing the behaviour )
        for (ShowSeat showSeat : showSeats) {
                try {
                    showSeat.getReentrantLock().lock();
                    showSeat.setValideTill(currentTime + "+ 10 mins");
                }
                catch (Exception e) {
                    System.out.println("some thing is wrong ");
                    showSeat.getReentrantLock().unlock();
                }

                showSeat.setSeatStatus(SeatStatus.RESERVED);
        }
        // save showSeats to the repository. 
        // since object is there show it not required for in membory.

        return true;
    }

    public int getId() {
        return id;
    }
}
