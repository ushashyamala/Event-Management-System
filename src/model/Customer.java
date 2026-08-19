package model;

public class Customer extends Person {
    private String customerId;

    public Customer(String name, int age, String customerId) {
        super(name, age);
        this.customerId = customerId;
    }

    @Override
    public String getDetails() {
        return "Customer: " + getName() + ", ID: " + customerId;
    }
}