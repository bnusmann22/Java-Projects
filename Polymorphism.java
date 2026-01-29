/**
 * POLYMORPHISM
 * 
 * Polymorphism means "many forms". It allows objects of different types to be treated
 * as objects of a common parent type. The same method can behave differently based on
 * the object that invokes it.
 * 
 * Types of Polymorphism:
 * 1. Compile-time Polymorphism (Method Overloading)
 * 2. Runtime Polymorphism (Method Overriding)
 * 
 * Key Benefits:
 * - Code reusability
 * - Flexibility and extensibility
 * - Clean and maintainable code
 */

// Example 1: Method Overloading (Compile-time Polymorphism)
class Calculator {
    // Same method name, different parameters
    
    // Add two integers
    public int add(int a, int b) {
        System.out.println("Adding two integers");
        return a + b;
    }
    
    // Add three integers
    public int add(int a, int b, int c) {
        System.out.println("Adding three integers");
        return a + b + c;
    }
    
    // Add two doubles
    public double add(double a, double b) {
        System.out.println("Adding two doubles");
        return a + b;
    }
    
    // Add an array of integers
    public int add(int[] numbers) {
        System.out.println("Adding array of integers");
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}

// Example 2: Method Overriding (Runtime Polymorphism)

// Parent class
abstract class Animal {
    protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    // Method to be overridden
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
    
    public void eat() {
        System.out.println(name + " is eating");
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract void move();
}

// Child classes
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " runs on four legs");
    }
    
    // Dog-specific method
    public void fetch() {
        System.out.println(name + " is fetching the ball");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " walks gracefully");
    }
}

class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Tweet! Tweet!");
    }
    
    @Override
    public void move() {
        System.out.println(name + " flies in the sky");
    }
}

// Example 3: Polymorphism with Interfaces
interface Shape {
    double calculateArea();
    double calculatePerimeter();
    void draw();
}

class Circle implements Shape {
    private double radius;
    
    public Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a circle with radius: " + radius);
    }
}

class Rectangle implements Shape {
    private double length;
    private double width;
    
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    public double calculateArea() {
        return length * width;
    }
    
    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with length: " + length + " and width: " + width);
    }
}

class Triangle implements Shape {
    private double side1, side2, side3;
    
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    
    @Override
    public double calculateArea() {
        // Using Heron's formula
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    
    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing a triangle with sides: " + side1 + ", " + side2 + ", " + side3);
    }
}

// Example 4: Polymorphism in action
class PaymentProcessor {
    public void processPayment(Payment payment, double amount) {
        payment.pay(amount);
    }
}

interface Payment {
    void pay(double amount);
}

class CreditCardPayment implements Payment {
    private String cardNumber;
    
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card ending in: " + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements Payment {
    private String email;
    
    public PayPalPayment(String email) {
        this.email = email;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        System.out.println("PayPal account: " + email);
    }
}

class CashPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Receiving cash payment of $" + amount);
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        System.out.println("=== POLYMORPHISM EXAMPLES ===\n");
        
        // Example 1: Method Overloading
        System.out.println("--- Example 1: Method Overloading ---");
        Calculator calc = new Calculator();
        System.out.println("Result: " + calc.add(5, 10));
        System.out.println("Result: " + calc.add(5, 10, 15));
        System.out.println("Result: " + calc.add(5.5, 10.5));
        System.out.println("Result: " + calc.add(new int[]{1, 2, 3, 4, 5}));
        
        // Example 2: Method Overriding with Animals
        System.out.println("\n--- Example 2: Method Overriding ---");
        Animal[] animals = {
            new Dog("Buddy"),
            new Cat("Whiskers"),
            new Bird("Tweety")
        };
        
        // Polymorphic behavior
        for (Animal animal : animals) {
            animal.makeSound();
            animal.move();
            animal.eat();
            System.out.println();
        }
        
        // Example 3: Polymorphism with Shapes
        System.out.println("--- Example 3: Interface Polymorphism ---");
        Shape[] shapes = {
            new Circle(5.0),
            new Rectangle(4.0, 6.0),
            new Triangle(3.0, 4.0, 5.0)
        };
        
        for (Shape shape : shapes) {
            shape.draw();
            System.out.printf("Area: %.2f\n", shape.calculateArea());
            System.out.printf("Perimeter: %.2f\n", shape.calculatePerimeter());
            System.out.println();
        }
        
        // Example 4: Payment Processing Polymorphism
        System.out.println("--- Example 4: Payment Processing ---");
        PaymentProcessor processor = new PaymentProcessor();
        
        Payment creditCard = new CreditCardPayment("1234567890123456");
        Payment paypal = new PayPalPayment("user@example.com");
        Payment cash = new CashPayment();
        
        processor.processPayment(creditCard, 150.00);
        System.out.println();
        processor.processPayment(paypal, 75.50);
        System.out.println();
        processor.processPayment(cash, 50.00);
    }
}
