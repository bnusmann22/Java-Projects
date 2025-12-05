import java.util.Scanner;

class Test {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter name:");
    
    // String input
    String name = input.nextLine();
    
    // Numerical input
    System.out.println("Enter age:");
    int age = input.nextInt();

    System.out.println("Enter salary:");
    double salary = input.nextDouble();

    // Output input by user
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("Salary: " + salary);

    input.close();
  }
}