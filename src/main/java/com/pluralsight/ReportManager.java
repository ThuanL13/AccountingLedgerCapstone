package com.pluralsight;

import java.time.LocalDate;

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

}
