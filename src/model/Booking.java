package model;

public class Booking {
    private String bookingId;
    private String eventId;
    private String customerId;

    public Booking(String bookingId, String eventId, String customerId) {
        this.bookingId = bookingId; this.eventId = eventId; this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Booking: " + bookingId + " | Event: " + eventId + " | Customer: " + customerId;
    }
}