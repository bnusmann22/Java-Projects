## Example1 (Tax discount program)
Write a program that;
1. Will accept the initial price  and tax rate of the product. 
  a. If the initial price of the product is over 100. Display to the user a congratulation message informing him/her that the company will pay half (1/2) of the tax rate for the product. 

2. Apply this special promo (discount) and calculates the cost of these products.

3. Display the product’s cost to the users.

Note: make use of the following formula to calculate the product cost: 
		cost = price * (1 + tax/100)


## User Inputs (Initial_Price, tax_rate) ✔️
import java.util.Scanner;
Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the current temperature(in ℃): ");
        float temp = input.nextFloat();

        input.close()

##  If the initial price of the product is over 100. Display to the user a congratulation message informing him/her that the company will pay half (1/2) of the tax rate for the product.