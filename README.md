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

## 📂 File Structure
BusinessLedger/
│
├── src/com/pluralsight/
│ ├── Main.java
│ ├── Homescreen.java
│ ├── Ledger.java
│ ├── Transaction.java
│ └── UtilitiesReport.java
│
└── transactions.csv ← Stores all saved transaction data

---


## 🛠️ How to Run
1. **Compile the project**
   ```bash
   javac com/pluralsight/*.java
Run the main class

bash
Copy code
java com.pluralsight.Main
Follow on-screen instructions to add deposits, payments, or view reports.

📈 Example Transaction File (transactions.csv)
makefile
Copy code
2025-10-16|11:15:58|Bonus Check|Target|2150.0
2025-10-16|11:18:15|Paycheck|Google|33000.0
2025-10-16|14:07:22|Debt Paid|Car Loan|-97500.0
2025-10-16|14:10:30|Direct Deposit|Social Security Back Pay|10000.0
✅ Key Notes
Positive amounts = Deposits (income)

Negative amounts = Payments (expenses)

Data is persistent — all entries are saved to transactions.csv and reloaded automatically.

The code uses | as a field delimiter to make parsing simple and avoid commas in text fields.

👨‍💻 Author
Angel LeGrande
Built with love, sweat, and tears in Java as part of the Pluralsight Business Ledger Project.
