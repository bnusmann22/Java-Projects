package Exercises;

import java.util.Scanner;

public class TaxCalc {

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.print("Enter the Initial Price: ");
        float initialPrice = myObj.nextFloat();

        System.out.print("Enter the Tax Rate: ");
        float taxRate = myObj.nextFloat();


        System.out.println("The initial Price is " + initialPrice);
        System.out.println("The Tax rate is " + taxRate);
        myObj.close();

        if (initialPrice > 100) {
            System.out.println("Congrats!!, The Company is paying half the TAX Rate");
            float cost = initialPrice * (1 + (taxRate/2)/100);
            System.out.println("The total cost is "+ cost);
        } else {   
            float cost = initialPrice * (1 + taxRate/100);
            System.out.println("The total cost is "+ cost);

        }
    }
}