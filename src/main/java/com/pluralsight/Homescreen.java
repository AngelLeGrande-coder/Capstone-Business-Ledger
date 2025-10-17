package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Homescreen {
    private static final Scanner scanner = new Scanner(System.in);

    public static void homeScreen() {

        System.out.println("👁️ Welcome to the CCG Financial Records Terminal 👁️");
        System.out.println("『 Tokyo Ghoul Edition 』 - Track your humanity... or your hunger.");

        boolean running = true;

        while (running) {
            System.out.println("\n===== ☕  ANTEIKU CONTROL PANEL  ☕ =====");
            System.out.println("D) Record ghoul territory earnings (Deposit)");
            System.out.println("P) Log CCG expenses or feeding activity (Payment)");
            System.out.println("L) Access full ghoul ledger");
            System.out.println("X) Retreat into the shadows (Exit)");
            System.out.print("Select your path: ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("D")) {
                addDeposit();
            } else if (choice.equals("P")) {
                addPayment();
            } else if (choice.equals("L")) {
                Ledger.openLedger();
            } else if (choice.equals("X")) {
                running = false;
                System.out.println("⚰️ Until next hunt, Kaneki... Stay human. ⚰️");
            } else {
                System.out.println("☠️ Invalid input. Even ghouls must follow protocol!");
            }
        }
    }

    private static void addDeposit() {
        try {
            System.out.println("\n=== 🩸 Record Ghoul Earnings ===");
            System.out.print("Enter operation details (description): ");
            String description = scanner.nextLine();

            System.out.print("Enter the allied vendor or ghoul group: ");
            String vendor = scanner.nextLine();

            double amount = 0;
            boolean validAmount = false;

            while (!validAmount) {
                System.out.print("Enter the yen amount acquired: ");
                String input = scanner.nextLine();

                try {
                    amount = Double.parseDouble(input);
                    validAmount = true;
                } catch (NumberFormatException e) {
                    System.out.println("☠️ Only numbers, no blood stains please!");
                }
            }

            LocalDateTime now = LocalDateTime.now();
            String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String csvFile = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;

            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(csvFile + "\n");
            writer.close();
            System.out.println("💉 Transaction logged successfully, Investigator.");
        } catch (IOException e) {
            System.out.println("🚨 Error accessing the ghoul database!");
        }
    }

    private static void addPayment() {
        try {
            System.out.println("\n=== 💀 Log Ghoul Payment ===");
            System.out.print("Enter operation details (description): ");
            String description = scanner.nextLine();

            System.out.print("Enter the CCG target or vendor name: ");
            String vendor = scanner.nextLine();

            double amount = 0;
            boolean validAmount = false;

            while (!validAmount) {
                System.out.print("Enter yen amount spent: ");
                String input = scanner.nextLine();

                try {
                    amount = Double.parseDouble(input);
                    if (amount <= 0) {
                        System.out.println("🩸 Must be a positive number, Kaneki!");
                    } else {
                        amount = -Math.abs(amount);
                        validAmount = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("☠️ Invalid input. Enter numeric yen values.");
                }
            }

            LocalDateTime now = LocalDateTime.now();
            String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String csvFile = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;

            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(csvFile + "\n");
            writer.close();
            System.out.println("🕸️ Payment recorded in the CCG archives.");
        } catch (IOException e) {
            System.out.println("🚨 Database corrupted. A ghoul must have tampered with it!");
        }
    }
}