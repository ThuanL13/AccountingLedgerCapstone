package com.pluralsight;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;

public class FileManager {
    // Constant to store file name
    private static final String FILE_NAME = "transactions.csv";
    // Creates transactions.csv if it doesn't already exist.
    public static void createFile() {
        try {
            File file = new File(FILE_NAME);
            if ((!file.exists())) { // If the file does not exist
                file.createNewFile(); // creates the new file
                System.out.println("transactions.csv file created!");
            }
        } catch (IOException e) {
            System.out.println("Error creating file");
        }
    }
    // Method for saving transaction to csv file
    public static void addTransaction(String description, String vendor, double amount) {
        try {// Try writing to file
            FileWriter writer = new FileWriter(FILE_NAME, true); // True = don't erase existing data
            // Builds one transaction line
            String line =
                    LocalDate.now() + "|" +
                            LocalTime.now().withNano(0) + // returns localtime and sets nanosecs to 0
                            "|" + description + "|" +
                            vendor + "|" +
                            amount + "\n";

            // Writes transactions into file
            writer.write(line);
            writer.close();
        }catch (IOException e) {
            System.out.println("Error writing transaction.");
        }
    }
    // Method to read all transactions from csv file
    // Also where the csv file will be parsed
    public static ArrayList<Transaction> loadTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>(); // Creating list to hold transactions
        try {
            BufferedReader bufReader = new BufferedReader(new FileReader(FILE_NAME));
            String line; // Stores one line
            while ((line = bufReader.readLine()) != null) { // Read until there is no more
                String[] parts = line.split("\\|"); // Split rows using "|"
                Transaction transaction = new Transaction(
                        LocalDate.parse(parts[0]), // Date -> Local Date
                        LocalTime.parse(parts[1]), // Time -> Local Time
                        parts[2], // Description of expense or sale
                        parts[3], // Supplier/Customer
                        Double.parseDouble(parts[4]) // Amount -> double
                );
                transactions.add(transaction); // Storing into Array List
            }
            bufReader.close();
        }catch (IOException e) {
            System.out.println("Error Reading File!"); // Error message
        }
        // Sorting transactions
        transactions.sort(Comparator.comparing(Transaction::getDate) // By Date
                .thenComparing(Transaction::getTime) // Then by Time
                .reversed()); // Reversing the order
        return transactions; // Returns completed list
    }
}
