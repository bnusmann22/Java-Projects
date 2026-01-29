/**
 * ENCAPSULATION
 * 
 * Encapsulation is the bundling of data (variables) and methods that operate on that data
 * within a single unit (class), and restricting direct access to some of the object's components.
 * 
 * Key Benefits:
 * - Data hiding and security
 * - Controlled access through getters and setters
 * - Flexibility to change implementation without affecting other code
 * - Better maintainability
 */

// Example 1: Basic Encapsulation - BankAccount class
class BankAccount {
    // Private fields - cannot be accessed directly from outside
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    // Public getter methods - controlled read access
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Public setter with validation - controlled write access
    public void setAccountHolder(String accountHolder) {
        if (accountHolder != null && !accountHolder.isEmpty()) {
            this.accountHolder = accountHolder;
        } else {
            System.out.println("Invalid account holder name");
        }
    }
    
    // Business logic methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }
    
    public void displayAccountInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}

// Example 2: Encapsulation with Read-Only Properties
class Employee {
    private final String employeeId;  // final - cannot be changed after initialization
    private String name;
    private double salary;
    private String department;
    
    public Employee(String employeeId, String name, double salary, String department) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    
    // Only getter for employeeId - read-only property
    public String getEmployeeId() {
        return employeeId;
    }
    
    // Getters and setters for other properties
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    // Salary is sensitive - only provide controlled access
    public double getSalary() {
        return salary;
    }
    
    // Only authorized personnel can change salary
    public void updateSalary(double newSalary, boolean isAuthorized) {
        if (isAuthorized && newSalary > 0) {
            this.salary = newSalary;
            System.out.println("Salary updated successfully");
        } else {
            System.out.println("Unauthorized or invalid salary update");
        }
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
}

// Example 3: Encapsulation with Data Validation
class Student {
    private String studentId;
    private String name;
    private int age;
    private double gpa;
    
    public Student(String studentId, String name, int age, double gpa) {
        this.studentId = studentId;
        setName(name);  // Using setter for validation
        setAge(age);
        setGpa(gpa);
    }
    
    public String getStudentId() {
        return studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name != null && name.length() >= 2) {
            this.name = name;
        } else {
            System.out.println("Invalid name");
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        if (age >= 5 && age <= 100) {
            this.age = age;
        } else {
            System.out.println("Invalid age. Must be between 5 and 100");
        }
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Invalid GPA. Must be between 0.0 and 4.0");
        }
    }
    
    public String getGradeLevel() {
        if (gpa >= 3.5) return "Excellent";
        else if (gpa >= 3.0) return "Good";
        else if (gpa >= 2.0) return "Average";
        else return "Needs Improvement";
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        System.out.println("=== ENCAPSULATION EXAMPLES ===\n");
        
        // Example 1: BankAccount
        System.out.println("--- Example 1: Bank Account ---");
        BankAccount account = new BankAccount("ACC001", "John Doe", 1000.0);
        account.displayAccountInfo();
        account.deposit(500);
        account.withdraw(300);
        account.displayAccountInfo();
        
        // Cannot access private fields directly - this would cause error:
        // account.balance = 10000;  // Compilation error!
        
        System.out.println("\n--- Example 2: Employee ---");
        Employee emp = new Employee("EMP001", "Jane Smith", 50000, "IT");
        System.out.println("Employee: " + emp.getName());
        System.out.println("Department: " + emp.getDepartment());
        System.out.println("Salary: $" + emp.getSalary());
        
        // Try to update salary without authorization
        emp.updateSalary(60000, false);
        
        // Update salary with authorization
        emp.updateSalary(60000, true);
        System.out.println("New Salary: $" + emp.getSalary());
        
        System.out.println("\n--- Example 3: Student with Validation ---");
        Student student = new Student("STU001", "Alice Johnson", 20, 3.8);
        System.out.println("Student: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("GPA: " + student.getGpa());
        System.out.println("Grade Level: " + student.getGradeLevel());
        
        // Try to set invalid values
        student.setAge(150);  // Invalid
        student.setGpa(5.0);  // Invalid
        
        // Set valid values
        student.setAge(21);
        student.setGpa(3.9);
        System.out.println("Updated Age: " + student.getAge());
        System.out.println("Updated GPA: " + student.getGpa());
    }
}
