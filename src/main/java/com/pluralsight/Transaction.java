package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    // Variables to store date, time, description, vendor and amount
    private final LocalDate date;
    private final LocalTime time;
    private final String description;
    private final String vendor;
    private final double amount;// Positive = Deposit | Negative = Payment

    // Constructor for creating new Transaction object
    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
    // Getters and Setters
    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
    public String getDescription() {
        return description;
    }
    public String getVendor() {
        return vendor;
    }
    public double getAmount() {
        return amount;
    }
    // For sout(t) to print out format
    @Override
    public String toString() {
        return "\uD83D\uDCDA" + date + " | "
                + "\uD83D\uDD52" + time + " | "
                + "\uD83D\uDCD6" + description + " | "
                + "\uD83D\uDC64" + vendor + " | "
                + String.format("\uD83D\uDCB0 $%.2f", amount);
    }
}
