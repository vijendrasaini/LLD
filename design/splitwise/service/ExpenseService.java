package design.splitwise.service;

import java.util.List;

import design.splitwise.enums.SplitType;
import design.splitwise.model.Expense;
import design.splitwise.model.Group;
import design.splitwise.model.Split;
import design.splitwise.model.SplitDetail;
import design.splitwise.model.User;
import design.splitwise.repository.ExpenseRepository;

public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Group group, User paidByUser, double amount, SplitDetail splitDetail) {
        Expense expense = new Expense(amount, paidByUser, group, splitDetail);
        expenseRepository.add(expense);
    }

    public SplitDetail getEqualSplitDetail(List<User> users) {
        SplitDetail splitDetail = new SplitDetail(SplitType.EQUAL);
        for (User user : users) {
            splitDetail.addSplit(new Split(user, 0));
        }

        return splitDetail;
    }

    public void settle() {}
    // public void editExpense() {}

}
