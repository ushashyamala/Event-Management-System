package service;
import model.*;
import java.util.*;

public class BookingManager {
    private Map<String, Booking> bookings = new HashMap<>();
    private static int bookingCount = 0;
    private static int ticketCount = 0;
    private static int paymentCount = 0;

    public void bookEvent(Event e, Customer c) {
        if (e.getAvailableSeats() > 0) {
            e.bookSeat();
            bookingCount++;
            String bookingId = String.format("B%03d", bookingCount);

            Booking b = new Booking(bookingId, e.getEventId(), c.getName());
            bookings.put(bookingId, b);
            ticketCount++;
            String ticketId = String.format("T%03d", ticketCount);
            Ticket t = new Ticket(ticketId, bookingId);
            paymentCount++;
            String paymentId = String.format("P%03d", paymentCount);
            Payment p = new Payment(paymentId, 500.0);
            System.out.println("Booking successful: " + b);
            System.out.println("Generated Ticket: " + t);
            System.out.println("Payment Done: " + p);
        } else {
            System.out.println("No seats available!");
        }
    }
}