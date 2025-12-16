package Exercises;

import java.util.*;

public class Loops {
    public static void main(String[] args) {
        double price,tax;
        char reply;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("-- Product Price Check --");
            System.out.println("Enter Initial Price: ");
            price = sc.nextDouble();

            System.out.println("Enter Tax rate: ");
            tax = sc.nextDouble();
            price = price * (1 + tax/100);

            System.out.println("Cost after tax = " + price);

            System.out.println();
            System.out.print("Would You like to enter another Product (y/n): ");
            reply = sc.next().charAt(0);
            System.out.println();
        } while (reply == 'y' || reply == 'Y');
        
        System.out.println();
        System.out.println("Thank You, Have a nice day!!");
        sc.close();
    }
}
