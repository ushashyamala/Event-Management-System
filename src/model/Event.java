package model;

public class Event {
    private String eventId;
    private String name;
    private Venue venue;
    private int availableSeats;

    // Inner Class
    public class Schedule {
        private String startTime, endTime;
        public Schedule(String s, String e) { startTime = s; endTime = e; }
        public String getSchedule() { return startTime + " - " + endTime; }
    }

    public Event(String eventId, String name, Venue venue, int seats) {
        this.eventId = eventId; this.name = name; this.venue = venue; this.availableSeats = seats;
    }

    // Copy Constructor
    public Event(Event e) {
        this.eventId = e.eventId; this.name = e.name; this.venue = e.venue; this.availableSeats = e.availableSeats;
    }

    public String getEventId() { return eventId; }
    public String getName() { return name; }
    public Venue getVenue() { return venue; }
    public int getAvailableSeats() { return availableSeats; }
    public void bookSeat() { if (availableSeats > 0) availableSeats--; }
    public void cancelSeat() { availableSeats++; }
    public void setName(String name) {
        this.name = name;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
    	return "Event ID: " + eventId + " | Event: " + name + " | Venue: " + venue +
    	" | Seats: " + availableSeats;
    }
} // (Composition + Inner Class + Copy Constructor)