package com.pluralsight;

import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ledger {

    public static void openLedger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your Business Ledger!");
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n===== LEDGER MENU =====");
            System.out.println("A) View All Transactions");
            System.out.println("D) View Only Deposits");
            System.out.println("P) View Only Payments");
            System.out.println("R) Open Reports");
            System.out.println("X) Return to Home Screen");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine().trim().toUpperCase();


            if (choice.equals("A")) {
                displayAll(loadTransactions());
            } else if (choice.equals("D")) {
                displayDeposits(loadTransactions());
            } else if (choice.equals("P")) {
                displayPayments(loadTransactions());
            } else if (choice.equals("R")) {
                openReports(scanner, loadTransactions());
            } else if (choice.equals(" X")) {
                isRunning = false;
                System.out.println("Returning to home screen...");
            } else {
                System.out.println("Invalid option, please try again!");
            }
        }
    }


    private static List<Transaction> loadTransactions() {
        List<Transaction> entries = new ArrayList<>();
        String fileName = "transactions.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                    Transaction t = new Transaction(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3],
                            Double.parseDouble(parts[4]) // amount
                    );
                    entries.add(t);
                }
            }


            Collections.reverse(entries);

        } catch (IOException e) {
            System.out.println(" Could not read transactions file: " + e.getMessage());
        }

        return entries;
    }


    private static void displayAll(List<Transaction> entries) {
        System.out.println("\n=== ALL TRANSACTIONS (Newest First) ===");
        for (Transaction t : entries) {
            System.out.println(t);
        }
    }


    private static void displayDeposits(List<Transaction> entries) {
        System.out.println("\n=== DEPOSITS ===");
        for (Transaction t : entries) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }


    private static void displayPayments(List<Transaction> entries) {
        System.out.println("\n=== PAYMENTS ===");
        for (Transaction t : entries) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }


    private static void openReports(Scanner scanner, List<Transaction> entries) {
        boolean inReports = true;

        while (inReports) {
            System.out.println("\n===== REPORT OPTIONS =====");
            System.out.println("A) Current Month");
            System.out.println("B) Last Month");
            System.out.println("C) Current Year");
            System.out.println("D) Last Year");
            System.out.println("E) Filter by Vendor");
            System.out.println("X) Go Back");
            System.out.print("Choose a report type: ");
            String option = scanner.nextLine().trim().toUpperCase();


            if (option.equals("A")) {
                UtilitiesReport.showMonthToDate(entries);
            } else if (option.equals("B")) {
                UtilitiesReport.showPreviousMonth(entries);
            } else if (option.equals("C")) {
                UtilitiesReport.showYearToDate(entries);
            } else if (option.equals("D")) {
                UtilitiesReport.showPreviousYear(entries);
            } else if (option.equals("E")) {
                System.out.print("Enter the vendor name: ");
                String vendor = scanner.nextLine();
                UtilitiesReport.showByVendor(entries, vendor);
            } else if (option.equals("X")) {
                inReports = false;
            } else {
                System.out.println(" Invalid option, please select A–E or X.");
            }
        }
    }
}