package com.pluralsight;

import java.io.File;
import java.io.*;

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
}
