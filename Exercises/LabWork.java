package Exercises;

import java.util.Scanner;

public class LabWork {
    
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Hello Lab work");
            System.out.println("""
                    Choose a Number from 1 - 3
                    """);
            choice = sc.nextInt();
        } while (choice != 3);

        sc.close();
    }
}
