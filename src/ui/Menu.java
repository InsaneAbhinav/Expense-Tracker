package ui;
import service.ExpenseService;
import java.util.Scanner;

public class Menu {

    private Scanner scan;
    private ExpenseService expenseService = new ExpenseService();


    public Menu() {
        this.scan = new Scanner(System.in);
    }

    public void start() {
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
                        System.out.print("Enter amount: ");

                        if (!scan.hasNextDouble()) {
                            System.out.println("Invalid amount. Please enter a number.");
                            scan.next(); // clear invalid input
                            break;
                        }

                        double amount = scan.nextDouble();
                        scan.nextLine(); // clear newline

                        System.out.print("Enter category: ");
                        String category = scan.nextLine();

                        expenseService.addExpense(amount, category);

                        System.out.println("Expense added successfully!");
                        break;
                    case 2:
                        if (expenseService.isEmpty()) {
                            System.out.println("No expenses added yet.");
                        } else {
                            System.out.println("\n--- Expenses ---");
                            for (var expense : expenseService.getAllExpenses()) {
                                System.out.println(
                                        "Category: " + expense.getCategory() +
                                                " | Amount: " + expense.getAmount()
                                );
                            }
                            System.out.println("----------------");
                        }
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
                scan.next();
            }
        }

        scan.close();
    }
}
