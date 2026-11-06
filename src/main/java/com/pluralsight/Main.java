package com.pluralsight;
import java.util.Scanner;

public class Main {
    // Scanner in public class Main to call throughout
    public static Scanner read = new Scanner(System.in);
    // Main Method
    public static void main(String[] args) {
        // Creates csv file if it doesn't exist
        FileManager.createFile();

        homeScreen();
    }
    // Method for home screen menu
    public static void homeScreen() {
        boolean running = true; // for the while loop to run home screen menu
        while (running) { // While running is true
            System.out.println("\n===^\uD83D\uDC31\uD83D\uDCDA FAT CAT BOOK STORE \uD83D\uDCDA\uD83D\uDC31^===");
            System.out.println("===========* Home Menu *===========");
            System.out.println("D) Record Book Sale");
            System.out.println("P) Record Store Expense");
            System.out.println("L) View Financial Ledger");
            System.out.println("X) Close Book Store");
            System.out.println("Please choose what you would like to do: ");

            String choice = read.nextLine().trim().toUpperCase(); // Reads user input, trims and brings it to uppercase

            // Switch for choice cases
            switch (choice) {
                case "D" -> addDeposit();
                case "P" -> addPayment();
                case "L" -> ledgerScreen();
                case "X" -> running = false; // Exits program, stops menu from running
                // If anything else is entered by user
                default -> System.out.println("Invalid input, please choose from D, P, L, or X.");
            }
        }
        System.out.println("Exiting Menu, Goodbye!"); // Prints exit message when X is chosen
    }
    // Method for deposit transaction
    public static void addDeposit() {
        // Asking for user input (Description, vendor, amount)
        System.out.println("Book: ");
        String description = read.nextLine();

        System.out.println("Customer: ");
        String vendor = read.nextLine();

        System.out.println("Sale Amount: ");
        // Converts input to a Double
        double amount = Double.parseDouble(read.nextLine());

        // Adds transaction and makes it a positive number
        FileManager.addTransaction(description, vendor, Math.abs(amount));
        System.out.println("✅ Book Sale Recorded! :)");
    }
    // Method for payment transaction
    public static void addPayment() {
        // Asking for user input
        System.out.println("Expense: ");
        String description = read.nextLine();

        System.out.println("Supplier: ");
        String vendor = read.nextLine();

        System.out.println("Expense Amount: ");
        // Converts input to a Double
        double amount = Double.parseDouble(read.nextLine());

        // Saves amount as negative
        FileManager.addTransaction(description, vendor, -Math.abs(amount));
        System.out.println("✅ Store Expense Recorded! :)");
    }
    // Ledger Menu
    public static void ledgerScreen() {
        boolean running = true;
        while (running) { // While running = true, show menu
            System.out.println("\n===^ Fat Cat Ledger ^===");
            System.out.println("A) Display All Transactions");
            System.out.println("D) View Book Sales");
            System.out.println("P) View Store Expenses");
            System.out.println("R) Go To Financial Reports");
            System.out.println("H) Home Screen");
            System.out.println("Please choose an option.");

            String choice = read.nextLine().toUpperCase();

            switch (choice) {
                case "A" -> LedgerManager.displayAll();
                case "D" -> LedgerManager.displayDeposits();
                case "P" -> LedgerManager.displayPayments();
                case "R" -> reportsScreen();
                case "H" -> running = false;

                default -> System.out.println("Invalid Choice.");
            }
        }
    }
    // Reports Menu
    public static void reportsScreen() {
        boolean running = true;
        while (running) {
            System.out.println("\n===^ Fat Cat Reports ^===");
            System.out.println("1) Current Month Sales & Expenses");
            System.out.println("2) Previous Month Summary");
            System.out.println("3) Current Year Summary");
            System.out.println("4) Previous Year Summary");
            System.out.println("5) Search Customer/Supplier");
            System.out.println("6) Custom Search");
            System.out.println("0) Go Back to Ledger");
            System.out.println("Please choose an option.");

            String choice = read.nextLine();

            switch (choice) {
                case "1" -> ReportManager.monthToDate();
                case "2" -> ReportManager.previousMonth();
                case "3" -> ReportManager.yearToDate();
                case "4" -> ReportManager.previousYear();
                case "5" -> {
                    System.out.println("Customer/Supplier Name: ");
                    String vendor = read.nextLine();
                    ReportManager.searchVendor(vendor);
                }
                // Custom search
                case "6" -> {
                    System.out.println("Start Date (yyyy-MM-dd): ");
                    String startDate = read.nextLine();

                    System.out.println("End Date (yyyy-MM-dd): ");
                    String endDate = read.nextLine();

                    System.out.println("Description: ");
                    String description = read.nextLine();

                    System.out.println("Customer/Supplier: ");
                    String vendor = read.nextLine();

                    System.out.println("Payment/Expense Amount: ");
                    String amount = read.nextLine();

                    ReportManager.customSearch(
                            startDate, endDate, description, vendor, amount);
                }
                case "0" -> running = false; // Leaves reports menu, goes back to ledger
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
