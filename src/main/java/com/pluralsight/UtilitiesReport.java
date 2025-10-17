package com.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UtilitiesReport {


    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static void showMonthToDate(List<Transaction> transactions) {
        LocalDate now = LocalDate.now();
        System.out.println("\n=== Month To Date ===");
        for (Transaction t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMAT);
            if ( date.getYear() == now.getYear() && date.getMonth() == now.getMonth()) {
                System.out.println(t);

            }
        }
    }


    public static void showPreviousMonth(List<Transaction> transactions) {
        LocalDate now = LocalDate.now();
        LocalDate prevMonth = now.minusMonths(1);
        System.out.println("\n=== Previous Month ===");
        for (Transaction t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMAT);
            if (date.getYear() == prevMonth.getYear() && date.getMonth() == prevMonth.getMonth()) {
                System.out.println(t);
            }
        }
    }


    public static void showYearToDate(List<Transaction> transactions) {
        LocalDate now = LocalDate.now();
        System.out.println("\n=== Year To Date ===");
        for (Transaction t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMAT);
            if (date.getYear() == now.getYear()) {
                System.out.println(t);
            }
        }
    }


    public static void showPreviousYear(List<Transaction> transactions) {
        LocalDate now = LocalDate.now();
        int prevYear = now.getYear() - 1;
        System.out.println("\n=== Previous Year ===");
        for (Transaction t : transactions) {
            LocalDate date = LocalDate.parse(t.getDate(), DATE_FORMAT);
            if (date.getYear() == prevYear) {
                System.out.println(t);
            }
        }
    }


    public static void showByVendor(List<Transaction> transactions, String vendorName) {
        System.out.println("\n=== Transactions for Vendor: " + vendorName + " ===");
        for (Transaction t : transactions) {
            if (t.getVendor().equalsIgnoreCase(vendorName.trim())) {
                System.out.println(t);
            }
        }
    }
}