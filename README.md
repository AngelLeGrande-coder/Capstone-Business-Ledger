# 🧾 Business Ledger CLI Application  

## 📘 Overview  
The **Business Ledger Application** is a simple Java-based CLI (Command-Line Interface) program that helps users **track financial transactions** for a small business or personal use.  
Users can record **deposits**, **payments**, and **view reports** such as monthly, yearly, and vendor-based summaries — all stored in a CSV file.  

---

## 🚀 Features  

### 🏠 Home Screen (`Homescreen.java`)
- **D)** Add a new deposit (positive transaction).  
- **P)** Add a payment (negative transaction).  
- **L)** Open the Ledger to view and filter transactions.  
- **X)** Exit the program.  

All entries are automatically saved to `transactions.csv` in the following format:  
---

### 📚 Ledger (`Ledger.java`)
Allows users to view and manage transaction data.  

Options include:  
- **A)** View All Transactions  
- **D)** View Deposits Only (positive amounts)  
- **P)** View Payments Only (negative amounts)  
- **R)** Open Financial Reports  
- **X)** Return to Home Screen  

The ledger reads data from `transactions.csv` and displays it in reverse chronological order (newest first).

---

### 📊 Reports (`UtilitiesReport.java`)
Generates detailed reports from stored transactions.  
Available options:
- **A)** Current Month  
- **B)** Previous Month  
- **C)** Current Year  
- **D)** Previous Year  
- **E)** Filter by Vendor  

---

### 💾 Transaction Model (`Transaction.java`)
Defines the structure of each transaction with:
- Date  
- Time  
- Description  
- Vendor  
- Amount  

Includes methods for:
- `toCSV()` — Convert a transaction into CSV format  
- `toString()` — Display transaction neatly in the console  

---

### 🧠 Main Class (`Main.java`)
Entry point of the program:
```java
public class Main {
    public static void main(String[] args) {
        Homescreen.homeScreen();
    }
}

# File Structure

BusinessLedger/
│
├── src/com/pluralsight/
│   ├── Main.java
│   ├── Homescreen.java
│   ├── Ledger.java
│   ├── Transaction.java
│   └── UtilitiesReport.java
│
└── transactions.csv   ← Stores all saved transaction data

#How to Run

