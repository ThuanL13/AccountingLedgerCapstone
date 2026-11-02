package com.pluralsight;

import java.io.File;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;

public class FileManager {
    // Constant to store file name
    private static final String fileName = "transactions.csv";
    // Creates transactions.csv if it doesn't already exist.
    public static void createFile() {
        try {
            File file = new File(fileName);
            if ((!file.exists())) { // If the file does not exist
                file.createNewFile(); // creates the new file
                System.out.println("transfactions.csv file created!");
            }
        } catch (IOException e) {
            System.out.println("Error creating file");
        }
    }
    // Method for saving transaction to csv file
    public static void addTransaction(String description, String vendor, double amount) {
        try {// Try writing to file
            FileWriter writer = new FileWriter(fileName, true); // True = don't erase existing data
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
}
