import model.*;
import service.BookingService;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) throws InterruptedException {
        build();
    }

    public static void build() throws InterruptedException {
        Movie movie = new Movie(1, "3 Idiots");

        Seat s1 = new Seat(1, "R1S1");
        Seat s2 = new Seat(2, "R1S2");

        ShowSeat showS1 = new ShowSeat(1, s1, 100.00);
        ShowSeat showS2 = new ShowSeat(2, s2, 200.00);
        Show nightShow = new Show(1, movie, List.of(showS1, showS2), LocalDateTime.now(), LocalDateTime.now().plusHours(3));

        BookingService bookingService = new BookingService();
        /*try {
            Booking booking = bookingService.bookSeats(1, List.of(showS1, showS2));
            System.out.println(booking);
        } catch (RuntimeException e) {
            System.out.println("Error message : " + e.getMessage());
        }*/

        Thread thread1 = new Thread(() -> {
            try {
                Booking booking = bookingService.bookSeats(1, List.of(showS1, showS2));
                System.out.println(booking);
            } catch (RuntimeException e) {
                System.out.println("Error message from T1: " + e.getMessage());
            }
        }, "T1");

        Thread thread2 = new Thread(() -> {
            try {
                Booking booking = bookingService.bookSeats(2, List.of(showS1, showS2));
                System.out.println(booking);
            } catch (RuntimeException e) {
                System.out.println("Error message from T2: " + e.getMessage());
            }
        }, "T2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}
