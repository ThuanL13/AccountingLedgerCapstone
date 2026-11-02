package com.pluralsight;
import java.util.*;
import java.util.Scanner;

public class Main {
    // Scanner in public class Main to call throughout
    public static Scanner read = new Scanner(System.in);
    // Main Method
    public static void main(String[] args) {
        homeScreen();

        //
    }
    // Method for home screen menu
    public static void homeScreen() {
        boolean running = true; // for the while loop to run home screen menu
        while (running) { // While running is true
            System.out.println("\n=== Accounting Ledger ===");
            System.out.println("D) Add a Deposit");
            System.out.println("P) Make a Payment");
            System.out.println("L) Check Ledger");
            System.out.println("X) Exit Menu");

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

}
