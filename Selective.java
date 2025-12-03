
import java.util.Scanner;

public class Selective {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the current temperature(in ℃): ");
        float temp = input.nextFloat();

        // try {
            
        // } catch (Exception e) {
        //     // TODO: handle exception
        // }

        if (temp < 0) {
            System.out.println("Its a bit freezing out there");
        } else if (temp > 40) {
            System.out.println("Its a bit HOT out there");
        }else{
            System.out.println("A nice day with  a nice weather");
        }


        input.close();
    }
}