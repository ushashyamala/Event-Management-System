package model;

public class Ticket {
    private String ticketId;
    private String bookingId;

    public Ticket(String ticketId, String bookingId) {
        this.ticketId = ticketId; this.bookingId = bookingId;
    }

    @Override
    public String toString() {
        return "Ticket: " + ticketId + " for Booking: " + bookingId;
    }
}