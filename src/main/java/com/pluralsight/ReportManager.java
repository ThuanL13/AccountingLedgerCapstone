package com.pluralsight;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;


public class ReportManager {
    public static void monthToDate() { // Month to date report
        LocalDate today = LocalDate.now(); // Storing today's date
        for (Transaction t : FileManager.loadTransactions()) {
            if (t.getDate().getMonth() == today.getMonth() // If transaction is in the current month
                && // And
                    t.getDate().getYear() == today.getYear()) { // if transaction is in current year
                System.out.println(t);
            }
        }
    }
    public static void previousMonth() {
        YearMonth previousMonth = YearMonth.now().minusMonths(1); // Returns previous month

        // Looping through all transactions
        for (Transaction t : FileManager.loadTransactions()) {
            YearMonth transactionMonth = YearMonth.from(t.getDate()); // Converts transaction date to YearMonth
            if (transactionMonth.equals(previousMonth)) { // If transaction was in previous month
                System.out.println(t);
            }
        }
    }
    public static void yearToDate() {
        int currentYear = LocalDate.now().getYear(); // Getting current year

        for (Transaction t : FileManager.loadTransactions()) { // Looping through transactions
            if (t.getDate().getYear() == currentYear) { // If transaction is in current year
                System.out.println(t);
            }
        }
    }
    public static void previousYear() {
        int previousYear = LocalDate.now().getYear() - 1; // Gets current year and goes back 1 year

        for (Transaction t : FileManager.loadTransactions()) {
            if (t.getDate().getYear() == previousYear) { // If transaction is in previous year
                System.out.println(t);
            }
        }
    }
    public static void searchVendor(String vendorName) {
        for (Transaction t : FileManager.loadTransactions()) {
            if (t.getVendor()
                    .toLowerCase()
                    .contains(vendorName.toLowerCase())) { // Can do partial search for vendor name
                System.out.println(t);
            }
        }
    }
    // *Bonus* Custom Search
    public static void customSearch(String startDate, String endDate, String description,
                                    String vendor, String amount) {
        ArrayList<Transaction> transactions = FileManager.loadTransactions(); // Loads every transaction

        // Initializing variables used in filtering
        LocalDate start = null;
        LocalDate end = null;
        Double amountValue = null;

        // Parsing string entered into LocalDates
        if (!startDate.isBlank()) {
            start = LocalDate.parse(startDate);
        }
        if (!endDate.isBlank()) {
            end =LocalDate.parse(endDate);
        }
        // Parsing string entered into Double
        if (!amount.isBlank()) {
            amountValue = Double.parseDouble(amount);
        }
        // Checking every transaction
        for (Transaction t : transactions) {
            // Assumes it matches unless false
            boolean matches = true;

            // Rejects dates before start date
            if (start != null && t.getDate().isBefore(start)) {
                matches = false;
            }
            // Rejects dates after end date
            if(end != null && t.getDate().isAfter(end)) {
                matches = false;
            }
            // Checking description filter
            if (!description.isBlank() &&
                    !t.getDescription().toLowerCase().contains(description.toLowerCase())) {
                matches = false;
            }
            // Vendor filter
            if (!vendor.isBlank() &&
                    !t.getVendor().toLowerCase().contains(vendor.toLowerCase())) {
                matches = false;
            }
            // Amount filter
            if (amountValue != null && Math.abs(t.getAmount() - amountValue) > 0.001) {
                matches = false;
            }
            // If transaction passes all filters
            if (matches) {
                System.out.println(t);
            }
        }
    }
}
