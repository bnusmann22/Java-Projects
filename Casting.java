/*
• Widening Casting (automatically) - converting a smaller type to a larger type size
byte -> short -> char -> int -> long -> float -> double

• Narrowing Casting (manually) - converting a larger type to a smaller size type
double -> float -> long -> int -> char -> short -> byte

*/

public class Casting {

    public static void main(String[] args) {
        int myInt = 9;
        double myDouble = myInt; //Widenning Casting

        double myNxtDouble = 9.78d;
        int myNxtInt = (int) myNxtDouble; //Narrow casting
        System.out.println(myDouble);
        System.out.println(myNxtInt);
    }
}