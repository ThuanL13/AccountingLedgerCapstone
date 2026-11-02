package com.pluralsight;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transactions {
    // Variables to store date, time, description, vendor and amount
    private LocalDate date;
    private LocalTime time;
    private String description;
    private String vendor;
    private double amount;// Positive = Deposit | Negative = Payment

    // Constructor for creating new Transaction object
    public Transactions(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }
}
