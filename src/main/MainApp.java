package main;
import java.util.*;
import model.*;
import service.*;
import exception.*;

public class MainApp {
    private static Scanner sc = new Scanner(System.in);
    private static EventManager eventManager = new EventManager();
    private static BookingManager bookingManager = new BookingManager();
    private static int customerCount = 0;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========== EVENT MANAGEMENT SYSTEM ==========");
            System.out.println("1. Admin");
            System.out.println("2. Organizer");
            System.out.println("3. Customer");
            System.out.println("4. View Events");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1: adminMenu(); break;
                case 2: organizerMenu(); break;
                case 3: customerMenu(); break;
                case 4: eventManager.viewEvents(); break;
                case 5: System.out.println("Exiting... Goodbye!"); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }
    private static void adminMenu() {

        while (true) {

            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. View Total Events");
            System.out.println("2. Update Event");
            System.out.println("3. Delete Event");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Total Events: "
                            + EventManager.getEventCount());
                    break;

                case 2:
                    System.out.print("Enter Event ID to update: ");
                    String updateId = sc.nextLine();

                    Event event = eventManager.fetch(updateId);

                    if (event != null) {

                        System.out.print("Enter New Event Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Venue Name: ");
                        String newVenueName = sc.nextLine();

                        System.out.print("Enter New City: ");
                        String newCity = sc.nextLine();

                        System.out.print("Enter New Available Seats: ");
                        int newSeats = sc.nextInt();
                        sc.nextLine();

                        event.setName(newName);
                        event.setVenue(new Venue(newCity, newVenueName));
                        event.setAvailableSeats(newSeats);

                        eventManager.update(event);

                        System.out.println("Event updated successfully!");

                    } else {
                        System.out.println("Event not found!");
                    }

                    break;

                case 3:
                    System.out.print("Enter Event ID to delete: ");
                    String deleteId = sc.nextLine();

                    Event deleteEvent = eventManager.fetch(deleteId);

                    if (deleteEvent != null) {

                        eventManager.delete(deleteId);

                        System.out.println("Event deleted successfully!");

                    } else {
                        System.out.println("Event not found!");
                    }

                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    private static void organizerMenu() {
        System.out.println("\n--- Organizer Menu ---");
        System.out.print("Enter Event Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Venue Name: ");
        String venueName = sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();
        System.out.print("Enter Available Seats: ");
        int seats = sc.nextInt();
        sc.nextLine();

        Venue v = new Venue(city, venueName);
        try {
            eventManager.insert(name, v, seats);
        } catch (InvalidEventDataException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void customerMenu() {

        System.out.println("\n--- Customer Menu ---");

        System.out.print("Enter Customer Name: ");
        String cname = sc.nextLine();

        System.out.print("Enter Customer Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        customerCount++;
        String customerId = String.format("C%03d", customerCount);

        Customer c = new Customer(cname, age, customerId);

        System.out.println("Customer Registered Successfully!");
        System.out.println(c.getDetails());

        System.out.print("Enter Event ID to book: ");
        String id = sc.nextLine().trim();

        Event e = eventManager.fetch(id);

        if (e != null) {
            bookingManager.bookEvent(e, c);
        } else {
            System.out.println("Event not found!");
        }
    }
}
