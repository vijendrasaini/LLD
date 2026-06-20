package design.splitwise;

import java.util.ArrayList;
import java.util.List;

import design.splitwise.enums.SplitType;
import design.splitwise.model.Group;
import design.splitwise.model.Split;
import design.splitwise.model.SplitDetail;
import design.splitwise.model.User;
import design.splitwise.repository.ExpenseRepository;
import design.splitwise.service.BalanceService;
import design.splitwise.service.ExpenseService;
import design.splitwise.strategy.SplitEqualStrategy;

public class Main {
    public static void main(String[] args) {
        Group group = new Group(1, "Group : Manage sharing room activities");
        User user1 = new User(1, "Vijendra");
        User user2 = new User(2, "Pranshant");
        User user3 = new User(3, "Aayush");

        ExpenseRepository expenseRepository = new ExpenseRepository();
        ExpenseService expenseService = new ExpenseService(expenseRepository);

        expenseService.addExpense(group, user1, 1000, expenseService.getEqualSplitDetail(List.of(user2, user3)));
        expenseService.addExpense(group, user1, 200, expenseService.getEqualSplitDetail(List.of(user2, user3)));
        expenseService.addExpense(group, user2, 200, expenseService.getEqualSplitDetail(List.of(user1, user3)));

        SplitStrategyFactory splitStrategyFactory = new SplitStrategyFactory();
        splitStrategyFactory.register(SplitType.EQUAL, () -> new SplitEqualStrategy());
        BalanceService balanceService = new BalanceService(expenseRepository, splitStrategyFactory);

        balanceService.getReport(user1, group);
        balanceService.getReport(user2, group);
        balanceService.getReport(user3, group);
    }
}
