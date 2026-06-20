package design.splitwise.service;


import design.splitwise.model.Expense;
import design.splitwise.model.Group;
import design.splitwise.model.SplitDetail;
import design.splitwise.model.User;
import design.splitwise.repository.ExpenseRepository;

public class ExpenseService {
    private ExpenseRepository expenseRepository;
    private BalanceService balanceService;

    public ExpenseService(ExpenseRepository expenseRepository, BalanceService balanceService) {
        this.expenseRepository = expenseRepository;
        this.balanceService = balanceService;
    }

    public Expense addExpense(Group group, User paidByUser, double amount, SplitDetail splitDetail) {
        validateExpenseInputs(amount);

        Expense expense = new Expense(amount, paidByUser, group, splitDetail);
        expenseRepository.add(expense);

        balanceService.updateBlance(expense);

        return expense;
    }

    public void validateExpenseInputs(double amount) {
        if(amount <= 0) {
            throw new RuntimeException("Invalid amount!");
        }
    }

}
