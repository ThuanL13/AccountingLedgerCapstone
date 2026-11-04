package com.pluralsight;
import java.util.*;
import java.util.Scanner;

public class Main {
    // Scanner in public class Main to call throughout
    public static Scanner read = new Scanner(System.in);
    // Main Method
    public static void main(String[] args) {
        homeScreen();
        // Creates csv file if it doesn't exist
        FileManager.createFile();
    }
    // Method for home screen menu
    public static void homeScreen() {
        boolean running = true; // for the while loop to run home screen menu
        while (running) { // While running is true
            System.out.println("\n===^ Accounting Ledger ^===");
            System.out.println("\n======* Home Menu *======");
            System.out.println("D) Add a Deposit");
            System.out.println("P) Make a Payment");
            System.out.println("L) Check Ledger");
            System.out.println("X) Exit Menu");
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
        System.out.println("Description: ");
        String description = read.nextLine();

        System.out.println("Vendor: ");
        String vendor = read.nextLine();

        System.out.println("Amount: ");
        // Converts input to a Double
        double amount = Double.parseDouble(read.nextLine());

        // Adds transaction and makes it a positive number
        FileManager.addTransaction(description, vendor, Math.abs(amount));
        System.out.println("Deposit saved! :)");
    }
    // Method for payment transaction
    public static void addPayment() {
        // Asking for user input
        System.out.println("Description: ");
        String description = read.nextLine();

        System.out.println("Vendor: ");
        String vendor = read.nextLine();

        System.out.println("Amount: ");
        // Converts input to a Double
        double amount = Double.parseDouble(read.nextLine());

        // Saves amount as negative
        FileManager.addTransaction(description, vendor, -Math.abs(amount));
        System.out.println("Payment Saved! :)");
    }
    // Ledger Menu
    public static void ledgerScreen() {
        boolean running = true;
        while (running) { // While running = true, show menu
            System.out.println("\n===^ Ledger Menu ^===");
            System.out.println("A) Display All");
            System.out.println("D) Display Deposits");
            System.out.println("P) Display Payments");
            System.out.println("R) Go To Reports");
            System.out.println("H) Home Screen");
            System.out.println("Please choose an option.");

            String choice = read.nextLine().toUpperCase();

            switch (choice) {
                case "A" -> LegderManager.displayAll();
                case "D" -> LegderManager.displayDeposits();
                case "P" -> LegderManager.displayPayments();
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
            System.out.println("\n===^ Reports ^===");
            System.out.println("1) Month to Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year to Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search by Vendor");
            System.out.println("6) Custom Search");
            System.out.println("0) Go Back");
            System.out.println("Please choose an option.");

            String choice = read.nextLine();

            switch (choice) {
                case "1" -> ReportManager.monthToDate();
                case "2" -> ReportManager.previousMonth();
                case "3" -> ReportManager.yearToDate();
                case "4" -> ReportManager.previousYear();
                case "5" -> {
                    System.out.println("Vendor Name: ");
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

                    System.out.println("Vendor: ");
                    String vendor = read.nextLine();

                    System.out.println("Amount: ");
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
