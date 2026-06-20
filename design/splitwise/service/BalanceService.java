package design.splitwise.service;

import java.util.List;

import design.splitwise.SplitStrategyFactory;
import design.splitwise.model.Expense;
import design.splitwise.model.Group;
import design.splitwise.model.SplitDetail;
import design.splitwise.model.User;
import design.splitwise.repository.ExpenseRepository;
import design.splitwise.strategy.SplitStrategy;

public class BalanceService {
    private ExpenseRepository expenseRepository;
    private SplitStrategyFactory splitStrategyFactory;

    public BalanceService(ExpenseRepository expenseRepository, SplitStrategyFactory splitStrategyFactory) {
        this.expenseRepository = expenseRepository;
        this.splitStrategyFactory = splitStrategyFactory;
    }

    double getExpenseData(User forUser, Group group) {
        List<Expense> expensesByGroupId = expenseRepository.getExpensesByGroupId(group.getId());

        for (Expense expense : expensesByGroupId) {
            SplitDetail splitDetail = expense.getSplitDetail();
            SplitStrategy splitStrategy = this.splitStrategyFactory.get(splitDetail.getSplitType());
            splitStrategy.calculate();
        }

        return 0;
    }

    public List<Expense> getParticpiatedExpenses(User user, Group group) {
        // Get total wherever user participated as a participant or as a payer
        List<Expense> expensesByGroupId = expenseRepository.getExpensesByGroupId(group.getId());
        return expensesByGroupId.stream()
                .filter(expense -> expense.getPaidBy() == user
                        || expense.getSplitDetail().getSplitParticipants().contains(user))
                .toList();
    }

    public double getTotalPaidByUser(User user, Group group) {
        return this.getParticpiatedExpenses(user, group).stream()
                .filter(expense -> expense.getPaidBy() == user)
                .reduce(0.0, (partialSum, expense) -> partialSum + expense.getAmount(), Double::sum);
    }

    public double getGroupTotalForUser(User user, Group group) {
        return this.getParticpiatedExpenses(user, group).stream()
                .reduce(0.0, (partialSum, expense) -> partialSum + expense.getAmount(), Double::sum);
    }

    public void getReport(User user, Group group) {
        System.out.println();
        System.out.println("Group : %s, User : %s".formatted(group.getName(), user));
        System.out.println("Group's Total : " + this.getGroupTotalForUser(user, group));
        System.out.println("    User contribution : " + this.getTotalPaidByUser(user, group));
    }
}
