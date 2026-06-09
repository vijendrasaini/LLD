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

    public int getId() {
        return id;
    }

    public synchronized boolean reserveSeats(List<ShowSeat> showSeats, int userId) {
        // this seats are contested resources so we will lock these.
        // let's first lock to all seats
        
        for (ShowSeat showSeat : showSeats) {
            showSeat.getReentrantLock().lock();
        }

        try {
            String currentTime = "current time"; // I will learn java date time handling than change it ( just now desing the behaviour )
            for (ShowSeat showSeat : showSeats) {
                if(SeatStatus.FREE != showSeat.getSeatStatus()) { // check since while putting no other thread changed the status
                    throw new RuntimeException("Seat with ID : %d is no longer free now.".formatted(showSeat.getSeat().getId()));
                }
            }
            
            for (ShowSeat showSeat : showSeats) {
                showSeat.setSeatStatus(SeatStatus.RESERVED);
                // if the seats are free than let's reserve them for 10 mins
                showSeat.setValideTill(currentTime + "+ 10 mins");
                showSeat.setReservedBy(userId);
            }
            
        } finally {
            for (ShowSeat showSeat : showSeats) {
                showSeat.getReentrantLock().unlock();
            }
        }

        return true;
    }

    public void freeExpiredReservedBooking(Show show) {
        for (ShowSeat showSeat : showSeats) {
            if (true ) { // i.e. showSeat.getSeatStatus == SeatStatus.RESERVED && showSeat.validTill < now // it means it's expired or not booked
                showSeat.setSeatStatus(SeatStatus.FREE);
                showSeat.setValideTill(null);
            }
        }
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void bookSeats(List<Integer> seatIds) {
        this.showSeats.stream().filter(showSeat -> seatIds.contains(showSeat.getSeat().getId())).forEach(showSeat -> showSeat.setSeatStatus(SeatStatus.BOOKED));
    }
}
