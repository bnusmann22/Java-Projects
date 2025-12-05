package Exercises;

public class Switches {
    public static void main(String[] args) {
        final int day = 324;
        String currDay = null;
        switch (day) {
            case 1:
                currDay ="Monday";
                break;
            case 2:
                currDay ="Tuesday";
                break;
            case 3:
                currDay ="Wednesday";
                break;
            case 4:
                currDay ="Thursday";
                break;
            case 5:
                currDay ="Friday";
                break;
            case 6:
                currDay ="Saturday";
                break;
            case 7:
                currDay ="Sunday";
                break;
            default:
                System.out.println("Wrong Input!!");
        } 

        System.out.println(currDay);
    }
}
