package Exercises;

import java.util.Scanner;

public class LabWork {
    
    static void discountApplied(int n){
        
        int order;
        double discount;
        Scanner sc = new Scanner(System.in);
        System.out.print("How many goods are you ordering today? ");
        order = sc.nextInt();
        if (order >= 12) {
            discount = 30;
            System.out.println("""
                                Congrats!!
                    """);
            System.out.println("You have " + discount + "% discount on your purchase!");
            if (n == 2) {
                if (order <= 12) {
                    discount = 15;
                    System.out.println("""
                        Congrats!!
                    """);
                    System.out.println("You have " + discount + "% discount on your purchase!");
                }else if(order >= 13 && order <= 48 ){
                    discount = 30;
                    System.out.println("""
                                        Congrats!!
                            """);
                    System.out.println("You have " + discount + "% discount on your purchase!");
                }
                }else if(order >= 49 && order <= 84){
                    discount = 40;
                    System.out.println("""
                                        Congrats!!
                            """);
                    System.out.println("You have " + discount + "% discount on your purchase!");
                }
            }

        sc.close();
    }
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Welcome to ABSAD Company");
            System.out.println("""
                    What type of customer are you: 
                    1. individual customer 
                    2. Retailer
                    
                    3. Exit
                    """);
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Welcome Individual Customer!");
                    discountApplied(choice);
                    break;
                    
                case 2:
                    System.out.println("Welcome Retailer!");
                    discountApplied(choice);
                    break;
                case 3:
                    System.out.println("Thank you for shopping with ABSAD Company");
                    break;
                default:
                    System.out.println("Invalid entry, please choose a valid Number");
                    break;
            }
        } while (choice != 3);
        

        sc.close();
    }
}
