**BEGINNER-FRIENDLY starter code base** + a **clear class diagram** you can share with everyone so each person starts from the **same foundation** and merges cleanly.

I’ve kept it **pure Java (OOP, console-based)** — no frameworks.

---

# 📐 CLASS DIAGRAM (Textual / ASCII)



```
                 ┌──────────────┐
                 │     User     │
                 ├──────────────┤
                 │ - username   │
                 │ - password   │
                 ├──────────────┤
                 │ + login()    │
                 └───────┬──────┘
                         │
           ┌─────────────┴─────────────┐
           │                           │
      ┌───────────┐             ┌────────────┐
      │  Admin    │             │ NormalUser │
      └───────────┘             └────────────┘


┌──────────────┐       ┌────────────────┐
│   Currency   │◄──────│  SubCurrency   │
├──────────────┤       ├────────────────┤
│ code         │       │ name           │
│ name         │       │ unitValue      │
│ symbol       │       └────────────────┘
└──────────────┘


┌──────────────────┐
│  ExchangeRate    │   
├──────────────────┤
│ fromCurrency     │
│ toCurrency       │
│ rate             │
└──────────────────┘


┌──────────────────┐
│ ConverterService │
├──────────────────┤
│ + convert()      │
└──────────────────┘


┌────────────────────┐
│ ConversionRecord   │
├────────────────────┤
│ amount             │
│ fromCurrency       │
│ toCurrency         │
│ result             │
│ timestamp          │
└────────────────────┘


┌──────────────────┐
│ HistoryService   │
├──────────────────┤
│ + addRecord()    │
│ + viewHistory()  │
└──────────────────┘


┌──────────────┐
│   MenuUI    │
├──────────────┤
│ + display() │
└──────────────┘
```

---

# 📁 PROJECT FOLDER STRUCTURE

```
CurrencyConverter/
└── src/
    ├── model/
    ├── service/
    ├── ui/
    ├── util/
    └── Main.java
```

---

# 🧩 STARTER CODE (COPY & SHARE)

## 1️⃣ `model/Currency.java`

```java
package model;

public class Currency {
    private String code;
    private String name;
    private String symbol;
    private SubCurrency subCurrency;

    public Currency(String code, String name, String symbol, SubCurrency subCurrency) {
        this.code = code;
        this.name = name;
        this.symbol = symbol;
        this.subCurrency = subCurrency;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public SubCurrency getSubCurrency() {
        return subCurrency;
    }
}
```

---

## 2️⃣ `model/SubCurrency.java`

```java
package model;

public class SubCurrency {
    private String name;
    private int unitValue; // e.g. 100 cents = 1 dollar

    public SubCurrency(String name, int unitValue) {
        this.name = name;
        this.unitValue = unitValue;
    }

    public String getName() {
        return name;
    }

    public int getUnitValue() {
        return unitValue;
    }
}
```

---

## 3️⃣ `model/User.java`

```java
package model;

public class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUser, String inputPass) {
        return username.equals(inputUser) && password.equals(inputPass);
    }
}
```

---

## 4️⃣ `model/Admin.java`

```java
package model;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }
}
```

---

## 5️⃣ `model/NormalUser.java`

```java
package model;

public class NormalUser extends User {
    public NormalUser(String username, String password) {
        super(username, password);
    }
}
```

---

## 6️⃣ `model/ExchangeRate.java`

```java
package model;

public class ExchangeRate {
    private Currency from;
    private Currency to;
    private double rate;

    public ExchangeRate(Currency from, Currency to, double rate) {
        this.from = from;
        this.to = to;
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
```

---

## 7️⃣ `service/ConverterService.java`

```java
package service;

import model.Currency;

public class ConverterService {

    public double convert(double amount, double rate) {
        return amount * rate;
    }

    // later: handle sub-currency conversion here
}
```

---

## 8️⃣ `model/ConversionRecord.java`

```java
package model;

import java.time.LocalDateTime;

public class ConversionRecord {
    private double amount;
    private Currency from;
    private Currency to;
    private double result;
    private LocalDateTime timestamp;

    public ConversionRecord(double amount, Currency from, Currency to, double result) {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.result = result;
        this.timestamp = LocalDateTime.now();
    }
}
```

---

## 9️⃣ `service/HistoryService.java`

```java
package service;

import model.ConversionRecord;
import java.util.ArrayList;
import java.util.List;

public class HistoryService {
    private List<ConversionRecord> history = new ArrayList<>();

    public void addRecord(ConversionRecord record) {
        history.add(record);
    }

    public void viewHistory() {
        for (ConversionRecord record : history) {
            System.out.println(record);
        }
    }
}
```

---

## 🔟 `ui/MenuUI.java`

```java
package ui;

import java.util.Scanner;

public class MenuUI {

    public void displayMenu() {
        System.out.println("=== Currency Converter ===");
        System.out.println("1. Convert Currency");
        System.out.println("2. View History");
        System.out.println("3. Exit");
    }
}
```

---

## 🧠 `Main.java`

```java
import ui.MenuUI;

public class Main {
    public static void main(String[] args) {
        MenuUI menu = new MenuUI();
        menu.displayMenu();
    }
}
```

---

# 👥 HOW TO ASSIGN THIS TO THE TEAM (IMPORTANT)

* Everyone **clones the same repo**
* Each group works in **their package only**
* No one edits `Main.java` except team lead
* Merge via **pull requests**

