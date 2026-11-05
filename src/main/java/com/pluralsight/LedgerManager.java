package com.pluralsight;

public class LedgerManager {
    public static void displayAll() { // Method to display all transactions
        for (Transaction t : FileManager.loadTransactions()) { // Loops through every transaction in .csv
            System.out.println(t); // Calling toString
        }
    }
    // Method to display only deposits
    public static void displayDeposits() {
        for (Transaction t : FileManager.loadTransactions()) {
            if (t.getAmount() > 0) { // if amount is > 0, Deposits are positive amounts
                System.out.println(t);
            }
        }
    }
    // Method to display only payments
    public static void displayPayments() {
        for (Transaction t : FileManager.loadTransactions()) {
            if (t.getAmount() < 0) { // Payments are in negative amounts
                System.out.println(t);
            }
        }
    }
}
