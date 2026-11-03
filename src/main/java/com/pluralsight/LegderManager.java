package com.pluralsight;

public class LegderManager {
    public static void displayAll() { // Method to display all transactions
        for (Transactions t : FileManager.loadTransactions()) { // Loops through every transaction in .csv
            System.out.println(t); // Calling toString
        }
    }
    // Method to display only deposits
    public static void displayDeposits() {
        for (Transactions t : FileManager.loadTransactions()) {
            if (t.getAmount() > 0) { // if amount is > 0, Deposits are postive amounts
                System.out.println(t);
            }
        }
    }
    // Method to display only payments
    public static void displayPayments() {
        for (Transactions t : FileManager.loadTransactions()) {
            if (t.getAmount() < 0) { // Payments are in negative amounts
                System.out.println(t);
            }
        }
    }
}
