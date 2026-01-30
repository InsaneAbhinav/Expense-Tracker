import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Expense Tracker ===");
            System.out.println("1. Add Expenses");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            if (scan.hasNextInt()) {
                int choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("You chose add expenses");
                        break;
                    case 2:
                        System.out.println("You chose view expenses");
                        break;
                    case 3:
                        System.out.println("Thank you!!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                }
            } else {
                System.out.println("Invalid input. Enter only numbers.");
                scan.next(); // clear invalid input
            }
        }

        scan.close();
    }
}