package interfaces;
import model.Event;
import exception.InvalidEventDataException;
public interface DatabaseOperations {
    void insert(Event e) throws InvalidEventDataException;
    void update(Event e);
    void delete(String eventId);
    Event fetch(String eventId);
    default void log(String msg) { System.out.println("LOG: " + msg); }
}