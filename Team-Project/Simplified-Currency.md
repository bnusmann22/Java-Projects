

# 💱 SIMPLIFIED CURRENCY CONVERTER (MODULE-BASED)

### Core Rule

* **Each currency = one module**
* **2–3 students own one currency**
* Each module **hard-codes conversion logic**
* Central system just *calls* the modules

---

## 🧠 SYSTEM IDEA (VERY SIMPLE)

* User enters amount + source currency + target currency
* System routes conversion to the **source currency module**
* That module knows how to convert **to all others**

---

## 📐 SIMPLE CLASS DIAGRAM

```
                Main
                 |
              Menu
                 |
        ┌────────┴─────────┐
        |                  |
   Converter           History
        |
   ┌────┴─────────────────────────────┐
   |        |        |        |        |
 USDModule NGNModule EURModule GBPModule ...
```

Each `*Module`:

* Has hard-coded rates
* Handles sub-currency
* Owned by a small group

---

## 📁 PROJECT STRUCTURE

```
CurrencyConverter/
└── src/
    ├── core/
    │   ├── Converter.java
    │   ├── Menu.java
    │   └── History.java
    ├── modules/
    │   ├── USDModule.java
    │   ├── NGNModule.java
    │   ├── EURModule.java
    │   ├── GBPModule.java
    │   └── ...
    └── Main.java
```

---

# 🧩 CORE STARTER CODE (EVERYONE USES THIS)

## 1️⃣ `core/Converter.java`

```java
package core;

import modules.*;

public class Converter {

    public double convert(String from, String to, double amount) {

        switch (from.toUpperCase()) {
            case "USD":
                return USDModule.convertTo(to, amount);
            case "NGN":
                return NGNModule.convertTo(to, amount);
            case "EUR":
                return EURModule.convertTo(to, amount);
            case "GBP":
                return GBPModule.convertTo(to, amount);
            default:
                System.out.println("Currency not supported");
                return 0;
        }
    }
}
```

---

## 2️⃣ `modules/USDModule.java`

(Assigned to **Group 1 – 2 or 3 people**)

```java
package modules;

public class USDModule {

    // Dollar → others
    public static double convertTo(String target, double amount) {

        switch (target.toUpperCase()) {
            case "NGN":
                return amount * 1550; // example rate
            case "EUR":
                return amount * 0.92;
            case "GBP":
                return amount * 0.79;
            case "USD":
                return amount;
            default:
                System.out.println("Target currency not supported");
                return 0;
        }
    }
}
```

---

## 3️⃣ `modules/NGNModule.java`

(**Group 2**)

```java
package modules;

public class NGNModule {

    // Naira → others
    public static double convertTo(String target, double amount) {

        switch (target.toUpperCase()) {
            case "USD":
                return amount / 1550;
            case "EUR":
                return amount / 1680;
            case "GBP":
                return amount / 1960;
            case "NGN":
                return amount;
            default:
                System.out.println("Target currency not supported");
                return 0;
        }
    }
}
```


## `core/History.java`
```java
package core;

import java.util.ArrayList;

public class History {

    // Stores each conversion as a simple string
    private static ArrayList<String> records = new ArrayList<>();

    public static void addRecord(String record) {
        records.add(record);
    }

    public static void showHistory() {
        if (records.isEmpty()) {
            System.out.println("No conversion history yet.");
            return;
        }

        System.out.println("\n=== Conversion History ===");
        for (int i = 0; i < records.size(); i++) {
            System.out.println((i + 1) + ". " + records.get(i));
        }
    }
}

---

## 4️⃣ SUB-CURRENCY HANDLING (VERY SIMPLE)

Rule:

```
TotalAmount = main + (sub / 100)

```

Example (USD):

```
2 Dollars 50 Cents → 2.50
```

Each module must:

* Convert **double amount**
* Display result back in **main + sub unit**

---

## 5️⃣ `core/Menu.java`

```java

package core;

import java.util.Scanner;

public class Menu {

    public void show() {
        Scanner sc = new Scanner(System.in);
        Converter converter = new Converter();

        while (true) {
            System.out.println("\n=== Currency Converter ===");
            System.out.println("1. Convert Currency");
            System.out.println("2. View History");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();

                System.out.print("From currency (USD, NGN, EUR): ");
                String from = sc.next();

                System.out.print("To currency: ");
                String to = sc.next();

                double result = converter.convert(from, to, amount);

                System.out.println("Converted Amount: " + result);

                // Save to history
                String record = amount + " " + from + " → " + result + " " + to;
                History.addRecord(record);

            } else if (choice == 2) {
                History.showHistory();

            } else if (choice == 3) {
                System.out.println("Exiting program...");
                break;

            } else {
                System.out.println("Invalid option!");
            }
        }
    }
}

```

---

## 6️⃣ `Main.java`

```java
import core.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.show();
    }
}
```

---

# 👥 TEAM ASSIGNMENT (20 STUDENTS)

| Currency  | Students |
| --------- | -------- |
| USD       | 2–3      |
| NGN       | 2–3      |
| EUR       | 2–3      |
| GBP       | 2–3      |
| CAD       | 2–3      |
| AUD       | 2–3      |
| SAR / AED | 2–3      |

(Adjust to reach 15 currencies)



---

# ⚠️ IMPORTANT RULES FOR THE TEAM

* **Do NOT edit Converter.java unless assigned**
* Each group edits **ONLY their module**
* Use **same method name**: `convertTo()`
* Use **same currency codes**

