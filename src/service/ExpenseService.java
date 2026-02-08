package service;

import model.Expense;
import java.util.*;

public class ExpenseService {

    private List<Expense> expenses;

    public ExpenseService() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(double amount, String category) {
        Expense expense = new Expense(amount, category);
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenses;
    }

    public boolean isEmpty() {
        return expenses.isEmpty();
    }
}
