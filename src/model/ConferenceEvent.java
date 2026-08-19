package model;
import interfaces.*;

public class ConferenceEvent extends Event implements CateringServices, EntertainmentServices {
    private String keynoteSpeaker;

    public ConferenceEvent(String id, String name, Venue v, int seats, String speaker) {
        super(id, name, v, seats);
        this.keynoteSpeaker = speaker;
    }

    @Override
    public void provideCatering() { System.out.println("Conference catering arranged."); }
    @Override
    public void provideEntertainment() { System.out.println("Conference entertainment arranged."); }

    @Override
    public String toString() {
        return super.toString() + " | Speaker: " + keynoteSpeaker;
    }
} // (Inheritance + Interfaces)