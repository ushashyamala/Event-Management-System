package model;

public class Venue {
    private String city;
    private String hallName;

    public Venue(String city, String hallName) {
        this.city = city; this.hallName = hallName;
    }
    @Override
    public String toString() { return hallName + ", " + city; }
}
