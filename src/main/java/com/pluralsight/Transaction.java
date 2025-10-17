package com.pluralsight;

public class Transaction {
    private String date;
    private String time;
    private String descriptions;
    private String vendor;
    private double amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Transaction(String date, String time, String descriptions, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.descriptions = descriptions;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String toCSV() {
        return date + "|" + time + "|" + descriptions + "|" + vendor + "|" + amount;
    }

    @Override
    public String toString() {
        return String.format( date + "|" + time + "|" + descriptions + "|" + vendor + "|" + amount);

    }
}