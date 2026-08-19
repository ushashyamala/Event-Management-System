package model;

public class Payment {
    private String paymentId;
    private double amount;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId; this.amount = amount;
    }

    @Override
    public String toString() {
        return "Payment: " + paymentId + " | Amount: " + amount;
    }
}