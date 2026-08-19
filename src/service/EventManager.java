package service;

import model.*;
import interfaces.*;
import exception.InvalidEventDataException;
import java.util.*;

public class EventManager implements DatabaseOperations {

    private static int eventCount = 0;

    public static final String COMPANY_NAME = "EventPro";

    private Map<String, Event> events = new HashMap<>();

    // Method Overloading
    public void insert(String name, Venue v, int seats)
            throws InvalidEventDataException {

        String eventId = String.format("E%03d", eventCount + 1);

        insert(new Event(eventId, name, v, seats));
    }

    @Override
    public void insert(Event e) throws InvalidEventDataException {

        if (e == null)
            throw new InvalidEventDataException("Invalid event data");

        events.put(e.getEventId(), e);

        eventCount++;

        log("Inserted: " + e);
    }

    @Override
    public void update(Event e) {

        if (e != null && events.containsKey(e.getEventId())) {

            events.put(e.getEventId(), e);

            log("Updated: " + e);

        } else {

            System.out.println("Event not found!");
        }
    }

    @Override
    public void delete(String id) {

        if (events.containsKey(id)) {

            events.remove(id);

            log("Deleted event: " + id);

        } else {

            System.out.println("Event not found!");
        }
    }

    @Override
    public Event fetch(String id) {

        return events.get(id);
    }

    public void viewEvents() {

        if (events.isEmpty()) {

            System.out.println("No events available.");

        } else {

            events.values().forEach(System.out::println);
        }
    }

    public static int getEventCount() {

        return eventCount;
    }
}
