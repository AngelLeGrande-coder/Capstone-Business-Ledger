package com.pluralsight;

public class Transaction {
    private String date;
    private String time;
    private String descriptions;
    private String vendor;
    private double amount;

    public Transaction(String date, String time, String descriptions, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.descriptions = descriptions;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getDescriptions() { return descriptions; }
    public String getVendor() { return vendor; }
    public double getAmount() { return amount; }

    @Override
    public String toString() {
        return String.format(date + " | " + time + " | " + descriptions + " | " + vendor + " | ¥" + amount);
    }
}