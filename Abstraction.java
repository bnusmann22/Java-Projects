/**
 * ABSTRACTION
 * 
 * Abstraction is the process of hiding complex implementation details and showing
 * only the essential features of an object. It focuses on WHAT an object does
 * rather than HOW it does it.
 * 
 * Ways to achieve Abstraction in Java:
 * 1. Abstract Classes (0-100% abstraction)
 * 2. Interfaces (100% abstraction)
 * 
 * Key Benefits:
 * - Reduces complexity by hiding implementation details
 * - Increases code reusability
 * - Provides a clear separation between interface and implementation
 * - Makes code more maintainable and flexible
 */

// Example 1: Abstract Class
abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    
    public Vehicle(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    
    // Abstract methods - no implementation
    public abstract void start();
    public abstract void stop();
    public abstract void accelerate(int speed);
    
    // Concrete method - has implementation
    public void displayInfo() {
        System.out.println("Vehicle: " + year + " " + brand + " " + model);
    }
    
    // Concrete method
    public String getBrand() {
        return brand;
    }
}

class Car extends Vehicle {
    private boolean isConvertible;
    
    public Car(String brand, String model, int year, boolean isConvertible) {
        super(brand, model, year);
        this.isConvertible = isConvertible;
    }
    
    @Override
    public void start() {
        System.out.println("Car engine started with ignition key");
    }
    
    @Override
    public void stop() {
        System.out.println("Car engine stopped");
    }
    
    @Override
    public void accelerate(int speed) {
        System.out.println("Car accelerating to " + speed + " km/h");
    }
    
    public void openRoof() {
        if (isConvertible) {
            System.out.println("Opening convertible roof");
        } else {
            System.out.println("This car doesn't have a convertible roof");
        }
    }
}

class Motorcycle extends Vehicle {
    private int engineCC;
    
    public Motorcycle(String brand, String model, int year, int engineCC) {
        super(brand, model, year);
        this.engineCC = engineCC;
    }
    
    @Override
    public void start() {
        System.out.println("Motorcycle engine started with kick/button");
    }
    
    @Override
    public void stop() {
        System.out.println("Motorcycle engine stopped");
    }
    
    @Override
    public void accelerate(int speed) {
        System.out.println("Motorcycle accelerating to " + speed + " km/h on " + engineCC + "cc engine");
    }
    
    public void wheelie() {
        System.out.println("Performing a wheelie!");
    }
}

// Example 2: Interface-based Abstraction
interface DatabaseConnection {
    void connect();
    void disconnect();
    void executeQuery(String query);
    boolean isConnected();
}

class MySQLConnection implements DatabaseConnection {
    private String host;
    private String database;
    private boolean connected;
    
    public MySQLConnection(String host, String database) {
        this.host = host;
        this.database = database;
        this.connected = false;
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to MySQL database at " + host);
        System.out.println("Database: " + database);
        connected = true;
        System.out.println("MySQL connection established");
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MySQL database");
        connected = false;
    }
    
    @Override
    public void executeQuery(String query) {
        if (connected) {
            System.out.println("Executing MySQL query: " + query);
        } else {
            System.out.println("Not connected to MySQL database");
        }
    }
    
    @Override
    public boolean isConnected() {
        return connected;
    }
}

class MongoDBConnection implements DatabaseConnection {
    private String host;
    private String database;
    private boolean connected;
    
    public MongoDBConnection(String host, String database) {
        this.host = host;
        this.database = database;
        this.connected = false;
    }
    
    @Override
    public void connect() {
        System.out.println("Connecting to MongoDB at " + host);
        System.out.println("Database: " + database);
        connected = true;
        System.out.println("MongoDB connection established");
    }
    
    @Override
    public void disconnect() {
        System.out.println("Disconnecting from MongoDB");
        connected = false;
    }
    
    @Override
    public void executeQuery(String query) {
        if (connected) {
            System.out.println("Executing MongoDB query: " + query);
        } else {
            System.out.println("Not connected to MongoDB");
        }
    }
    
    @Override
    public boolean isConnected() {
        return connected;
    }
}

// Example 3: Multiple Interface Implementation
interface Drawable {
    void draw();
}

interface Resizable {
    void resize(double factor);
}

interface Movable {
    void move(int x, int y);
}

class GraphicObject implements Drawable, Resizable, Movable {
    private String name;
    private int x, y;
    private double size;
    
    public GraphicObject(String name, int x, int y, double size) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.size = size;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing " + name + " at position (" + x + ", " + y + ") with size " + size);
    }
    
    @Override
    public void resize(double factor) {
        size *= factor;
        System.out.println("Resized " + name + " by factor " + factor + ". New size: " + size);
    }
    
    @Override
    public void move(int newX, int newY) {
        System.out.println("Moving " + name + " from (" + x + ", " + y + ") to (" + newX + ", " + newY + ")");
        x = newX;
        y = newY;
    }
}

// Example 4: Real-world Abstraction - Banking System
abstract class BankingOperation {
    protected String accountNumber;
    protected double amount;
    
    public BankingOperation(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
    
    // Template method
    public final void execute() {
        if (validate()) {
            performOperation();
            logTransaction();
            System.out.println("Operation completed successfully\n");
        } else {
            System.out.println("Operation failed validation\n");
        }
    }
    
    // Abstract methods - must be implemented by subclasses
    protected abstract boolean validate();
    protected abstract void performOperation();
    
    // Concrete method
    protected void logTransaction() {
        System.out.println("Logging transaction for account: " + accountNumber);
    }
}

class DepositOperation extends BankingOperation {
    public DepositOperation(String accountNumber, double amount) {
        super(accountNumber, amount);
    }
    
    @Override
    protected boolean validate() {
        System.out.println("Validating deposit operation...");
        return amount > 0;
    }
    
    @Override
    protected void performOperation() {
        System.out.println("Depositing $" + amount + " to account " + accountNumber);
    }
}

class WithdrawalOperation extends BankingOperation {
    private double accountBalance;
    
    public WithdrawalOperation(String accountNumber, double amount, double accountBalance) {
        super(accountNumber, amount);
        this.accountBalance = accountBalance;
    }
    
    @Override
    protected boolean validate() {
        System.out.println("Validating withdrawal operation...");
        return amount > 0 && amount <= accountBalance;
    }
    
    @Override
    protected void performOperation() {
        System.out.println("Withdrawing $" + amount + " from account " + accountNumber);
    }
}

class TransferOperation extends BankingOperation {
    private String targetAccount;
    private double sourceBalance;
    
    public TransferOperation(String sourceAccount, String targetAccount, double amount, double sourceBalance) {
        super(sourceAccount, amount);
        this.targetAccount = targetAccount;
        this.sourceBalance = sourceBalance;
    }
    
    @Override
    protected boolean validate() {
        System.out.println("Validating transfer operation...");
        return amount > 0 && amount <= sourceBalance && !accountNumber.equals(targetAccount);
    }
    
    @Override
    protected void performOperation() {
        System.out.println("Transferring $" + amount + " from account " + accountNumber + " to " + targetAccount);
    }
}

public class Abstraction {
    public static void main(String[] args) {
        System.out.println("=== ABSTRACTION EXAMPLES ===\n");
        
        // Example 1: Abstract Class - Vehicles
        System.out.println("--- Example 1: Abstract Classes ---");
        Vehicle car = new Car("Toyota", "Camry", 2023, false);
        car.displayInfo();
        car.start();
        car.accelerate(80);
        car.stop();
        
        System.out.println();
        
        Vehicle motorcycle = new Motorcycle("Harley-Davidson", "Street 750", 2023, 750);
        motorcycle.displayInfo();
        motorcycle.start();
        motorcycle.accelerate(120);
        motorcycle.stop();
        
        // Example 2: Interface-based Abstraction
        System.out.println("\n--- Example 2: Interface Abstraction ---");
        DatabaseConnection mysqlConn = new MySQLConnection("localhost:3306", "myapp_db");
        mysqlConn.connect();
        mysqlConn.executeQuery("SELECT * FROM users");
        mysqlConn.disconnect();
        
        System.out.println();
        
        DatabaseConnection mongoConn = new MongoDBConnection("localhost:27017", "myapp_db");
        mongoConn.connect();
        mongoConn.executeQuery("db.users.find()");
        mongoConn.disconnect();
        
        // Example 3: Multiple Interfaces
        System.out.println("\n--- Example 3: Multiple Interfaces ---");
        GraphicObject logo = new GraphicObject("Company Logo", 100, 200, 50.0);
        logo.draw();
        logo.move(150, 250);
        logo.resize(1.5);
        logo.draw();
        
        // Example 4: Banking Operations
        System.out.println("\n--- Example 4: Banking System Abstraction ---");
        BankingOperation deposit = new DepositOperation("ACC001", 500.0);
        deposit.execute();
        
        BankingOperation withdrawal = new WithdrawalOperation("ACC001", 200.0, 1000.0);
        withdrawal.execute();
        
        BankingOperation transfer = new TransferOperation("ACC001", "ACC002", 300.0, 800.0);
        transfer.execute();
        
        // Invalid operation
        BankingOperation invalidWithdrawal = new WithdrawalOperation("ACC001", 1000.0, 500.0);
        invalidWithdrawal.execute();
    }
}
