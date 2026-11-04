package com.pluralsight;

import java.time.LocalDate;
import java.time.YearMonth;

public class ReportManager {
    public static void monthToDate() { // Month to date report
        LocalDate today = LocalDate.now(); // Storing today's date
        for (Transactions t : FileManager.loadTransactions()) {
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
        for (Transactions t : FileManager.loadTransactions()) {
            YearMonth transactionMonth = YearMonth.from(t.getDate()); // Converts transaction date to YearMonth
            if (transactionMonth.equals(previousMonth)) { // If transaction was in previous month
                System.out.println(t);
            }
        }
    }
    public static void yearToDate() {
        int currentYear = LocalDate.now().getYear(); // Getting current year

        for (Transactions t : FileManager.loadTransactions()) { // Looping through transactions
            if (t.getDate().getYear() == currentYear) { // If transaction is in current year
                System.out.println(t);
            }
        }
    }
    public static void previousYear() {
        int previousYear = LocalDate.now().getYear() - 1; // Gets current year and goes back 1 year

        for (Transactions t : FileManager.loadTransactions()) {
            if (t.getDate().getYear() == previousYear) { // If transaction is in previous year
                System.out.println(t);
            }
        }
    }
    public static void searchVendor(String vendorName) {
        for (Transactions t : FileManager.loadTransactions()) {
            if (t.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.println(t);
            }
        }
    }
    // *Bonus* Custom Search
    public static void customSearch(String startDate, String endDate, String description,
                                    String vendor, String amount) {

    }
}
