package design.splitwise.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    Map<Integer, Expense> expenses;
    private static int counter = 0;

    public Repository() {
        this.expenses = new HashMap<>();
    }

    public void add(Expense expense) {
        this.expenses.put(++counter, expense);
    }

    public Expense get(int transId) {
        if(this.expenses.get(transId) == null) {
            throw new RuntimeException("expense not found for ID : " + transId);
        }
        
        return this.expenses.get(transId);
    }

    public List<Expense> getforGroup(int groupId) {
        return this.expenses.values().stream()
                .filter(expense -> expense.getGroupId() == groupId)
                .toList();
    }

    public void update(int transId, Expense expense) {
        if(this.expenses.get(transId) == null) {
            throw new RuntimeException("expense not found for ID : " + transId);
        }

        this.expenses.put(transId, expense);
    }
}
