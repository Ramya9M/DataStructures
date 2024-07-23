import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MovieTicketBooking {

    private final int totalSeat = 10;

    private int lastBookedSeat = 0;

    public synchronized String book(int numberOfSeats) {

        String response;

        if (lastBookedSeat == totalSeat) {
            response = "House Full! " + Thread.currentThread().getName();
        } else if (lastBookedSeat + numberOfSeats > totalSeat) {
            response = "Enough Seats Not Available " + Thread.currentThread().getName();
        } else {
            response = lastBookedSeat + 1 + " to ";
            lastBookedSeat += numberOfSeats;
            response += lastBookedSeat + " Seats Booked " + Thread.currentThread().getName();
        }

        return response;
    }
}

class Customer {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4); //4 threads means 4 different counters.

        MovieTicketBooking movieTicketBooking = new MovieTicketBooking();

        for (int i = 0; i < 6; i++) { //6 customers
            threadPool.submit(() -> {
                System.out.println(movieTicketBooking.book(2));
            });
        }
        threadPool.shutdown();
    }

}