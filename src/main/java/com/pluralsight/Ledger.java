package com.pluralsight;

import java.io.*;
import java.util.*;
import java.time.LocalDate;

public class Ledger {

    public static void openLedger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("📜 Welcome to the Ghoul Ledger — the record of your sins.");
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n===== ⚖️  GHOUL ACCOUNT MENU  ⚖️ =====");
            System.out.println("A) Review All Transactions");
            System.out.println("D) View Income (Feedings / Acquisitions)");
            System.out.println("P) View Expenses (CCG Interactions)");
            System.out.println("R) Generate CCG Report");
            System.out.println("X) Return to Anteiku");
            System.out.print("Choose your fate: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("A")) {
                displayAll(loadTransactions());
            } else if (choice.equals("D")) {
                displayDeposits(loadTransactions());
            } else if (choice.equals("P")) {
                displayPayments(loadTransactions());
            } else if (choice.equals("R")) {
                openReports(scanner, loadTransactions());
            } else if (choice.equals("X")) {
                isRunning = false;
                System.out.println("☕ Returning to Anteiku... Hide your kagune.");
            } else {
                System.out.println("🩸 Invalid choice. Choose wisely, one-eyed king.");
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
                            Double.parseDouble(parts[4])
                    );
                    entries.add(t);
                }
            }

            Collections.reverse(entries);

        } catch (IOException e) {
            System.out.println("⚰️ Could not open ghoul transaction file: " + e.getMessage());
        }

        return entries;
    }

    private static void displayAll(List<Transaction> entries) {
        System.out.println("\n=== 🩸 ALL GHOUL TRANSACTIONS (Newest First) ===");
        for (Transaction t : entries) {
            System.out.println(t);
        }
    }

    private static void displayDeposits(List<Transaction> entries) {
        System.out.println("\n=== 💰 INCOME RECORDS ===");
        for (Transaction t : entries) {
            if (t.getAmount() > 0) {
                System.out.println(t);
            }
        }
    }

    private static void displayPayments(List<Transaction> entries) {
        System.out.println("\n=== 💀 EXPENSES / LOSSES ===");
        for (Transaction t : entries) {
            if (t.getAmount() < 0) {
                System.out.println(t);
            }
        }
    }

    private static void openReports(Scanner scanner, List<Transaction> entries) {
        boolean inReports = true;

        while (inReports) {
            System.out.println("\n===== 🕯️ CCG REPORT TERMINAL 🕯️ =====");
            System.out.println("A) Current Month Activity");
            System.out.println("B) Previous Month");
            System.out.println("C) Year to Date");
            System.out.println("D) Previous Year");
            System.out.println("E) Filter by Ghoul/Vendor");
            System.out.println("X) Return");
            System.out.print("Select report: ");
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
                System.out.print("Enter ghoul or vendor name: ");
                String vendor = scanner.nextLine();
                UtilitiesReport.showByVendor(entries, vendor);
            } else if (option.equals("X")) {
                inReports = false;
            } else {
                System.out.println("☠️ Invalid input — even ghouls need discipline!");
            }
        }
    }
}
