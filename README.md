# 🐱📚 Fat Cat Book Store Financial Ledger

## Description:

Fat Cat Book Store Financial Ledger is a Java application designed to track the financial activity of a bookstore. The program allows users to record book sales, track store expenses, view transaction history, and generate financial reports.

All transactions are stored in a CSV file (transactions.csv), allowing records to be saved and accessed between program runs.

This project demonstrates:

* Object-Oriented Programming (OOP)
* File handling with CSV files
* Collections using ArrayLists
* Date and time APIs
* Menu-driven user interaction
* Search and report function
## Features
* Record book sales as deposits
* Record store expenses as payments
* View all transactions
* View sales-only transactions
* View expense-only transactions
* Generate monthly and yearly financial reports
* Search by customer or vendor
* Perform custom searches using multiple filters

## Program Navigation

## Home Menu

D) Record Book 

P) Record Store Expense

L) View Financial Ledger

X) Close Book Store

Selecting "L" will open the ledger menu

## Ledger Menu

A) Display All Transactions

D) View Book Sales

P) View Store Expenses

R) Go to Financial Reports

H) Home Screen

Selecting "R" will open the reports menu

## Reports Menu

1) Current Month Sales & Expenses

2) Previous Month Summary

3) Current Year Summary

4) Previous Year Summary 

5) Search Customer/Supplier

6) Custom Search

0) Go Back to Ledger

## Project Structure

com.pluralsight

│

├── Main.java : Handles menus and user interaction

├── FileManager.java : Creates, reads, and writes CSV files

├── LedgerManager.java : Displays transaction information

├── ReportManager.java : Generates reports and performs searches

├── Transaction.java : Stores transaction data

└── transactions.csv : File Structure to hold reports 

## Transaction Format

Transactions are stored in transactions.csv in the following format:

date|time|book|customer/supplier|amount

# Author

Thuan Luu

First Java Capstone Project

Fat Cat Book Store Financial Ledger


