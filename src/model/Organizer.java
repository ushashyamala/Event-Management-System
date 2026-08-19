package model;

public class Organizer extends Person {
    private String organizerId;

    public Organizer(String name, int age, String organizerId) {
        super(name, age);
        this.organizerId = organizerId;
    }

    @Override
    public String getDetails() {
        return "Organizer: " + getName() + ", ID: " + organizerId;
    }
}