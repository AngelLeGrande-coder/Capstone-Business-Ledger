package com.pluralsight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

  class Homescreen {
    private static final Scanner scanner = new Scanner(System.in);

    public static void homeScreen() {


        System.out.println("Welcome to your Business Account!!!");


        boolean running = true;


        while (running) {
            System.out.println("\n===== HOME SCREEN DECISIONS =====");
            System.out.println("D) Add deposit for the day");
            System.out.println("P) Make payment for bills or paying your employees (Debit)");
            System.out.println("L) Open ledger");
            System.out.println("X) Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim().toUpperCase();


            if (choice.equals("D")) {
                addDeposit();
            } else if (choice.equals("P")) {
                addPayment();
            } else if (choice.equals("L")) {
                Ledger.openLedger();
            } else if (choice.equals("X")) {
                running = false;
                System.out.println("See you next time , Goodbye!!");
            } else {
                System.out.println("Invalid option! Please choose D, P, L, or X.");
            }
        }
    }

    private static void addDeposit() {
        try {
            System.out.println("\n=== Add Deposit ===");
            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            System.out.print("Enter the Vendor Name: ");
            String vendor = scanner.nextLine();

            double amount = 0;
            boolean validAmount = false;

            while (!validAmount) {
                System.out.print("Enter the amount: ");
                String input = scanner.nextLine();

                try {
                    amount = Double.parseDouble(input);
                    validAmount = true;
                } catch (NumberFormatException e) {
                    System.out.println("Please enter numbers only! (Example: 123.45)");
                }
            }

            LocalDateTime now = LocalDateTime.now();
            String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String csvFile = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;

            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(csvFile + "\n");
            writer.close();
            System.out.println("Deposit saved YAY!");
        } catch (IOException e) {
            System.out.println("Error catching the file!");
        }
    }

    private static void addPayment() {
        try {
            System.out.println("\n=== Make Payment ===");
            System.out.print("Enter description: ");
            String description = scanner.nextLine();

            System.out.print("Enter the Vendor name: ");
            String vendor = scanner.nextLine();

            double amount = 0;
            boolean validAmount = false;

            while (!validAmount) {
                System.out.print("Enter the payment amount: ");
                String input = scanner.nextLine();

                try {
                    amount = Double.parseDouble(input);
                    if (amount <= 0) {
                        System.out.println("Please enter a positive number!");
                    } else {
                        amount = -Math.abs(amount);
                        validAmount = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter numbers only!");
                }
            }

            LocalDateTime now = LocalDateTime.now();
            String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String time = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            String csvFile = date + "|" + time + "|" + description + "|" + vendor + "|" + amount;

            FileWriter writer = new FileWriter("transactions.csv", true);
            writer.write(csvFile + "\n");
            writer.close();
            System.out.println("Payment saved! Congrats!");
        } catch (IOException e) {
            System.out.println("Error catching the file, please try again!");
        }
    }
}