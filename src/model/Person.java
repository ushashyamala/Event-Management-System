package model;

public abstract class Person {
    private String name;
    private int age;
    static String organization;

    static {
        organization = "EventPro Pvt Ltd";
        System.out.println("Static block executed. Organization set.");
    }

    public Person(String name, int age) {
        this.name = name; this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract String getDetails();
} //(Abstract + Static Block)