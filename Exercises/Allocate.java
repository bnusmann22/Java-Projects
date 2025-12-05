package Exercises;

import java.util.Scanner;

public class Allocate {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("This is a laboratory Allocator program");
        System.out.print("Enter the last 4 digits of your reg No: ");
        int regNum = input.nextInt();
        System.out.println(regNum);

        boolean condition = regNum % 2 == 0;

        System.out.println(condition);
        switch(condition) {
            
            case true:
                System.out.println("Even Number, You belong to LAB 4");
                break;
            default:
                System.out.println("Odd Number, You belong to LAB 3");
                break;
        }

        // if (regNum % 2 == 0) {
        //    System.out.println("Even Number, You belong to LAB 4"); 
        // }else{
        //     System.out.println("Odd Number, You belong to LAB 3");
        // }

        input.close();
    }
}