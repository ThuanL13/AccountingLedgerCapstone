package com.pluralsight;

public class LegderManager {
    public static void displayAll() { // Method to display all transactions
        for (Transactions t : FileManager.loadTransactions()) { // Loops through every transaction in .csv
            System.out.println(t); // Calling toString
        }
    }
}
