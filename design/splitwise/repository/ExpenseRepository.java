package design.splitwise.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design.splitwise.model.Expense;

public class ExpenseRepository implements Repository<Expense> {
    Map<Integer, Expense> expenses;
    private static int counter = 0;

    public ExpenseRepository() {
        this.expenses = new HashMap<>();
    }

    @Override
    public int add(Expense t) {
        int id = ++counter;
        t.setId(id);
        this.expenses.put(id, t);
        return id;
    }

    @Override
    public Expense getById(int i) {
        return this.expenses.get(i);
    }

    @Override
    public List<Expense> getAll() {
        return new ArrayList<>(this.expenses.values());
    }

    @Override
    public void delete(int id) {
        this.expenses.remove(id);
    }

    @Override
    public void updateById(int id, Expense data) {
        this.expenses.put(id, data);
    }

    public List<Expense> getExpensesByGroupId(int groupId) {
        return this.expenses.values()
                .stream()
                .filter(expense -> expense.getGroup().getId() == groupId)
                .toList();
    }
}
