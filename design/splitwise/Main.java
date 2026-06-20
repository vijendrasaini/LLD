package design.splitwise;

import java.util.List;

import design.splitwise.dto.UserPercentage;
import design.splitwise.model.EqualSplitDetail;
import design.splitwise.model.Group;
import design.splitwise.model.PercentageSplitDetail;
import design.splitwise.model.User;
import design.splitwise.repository.BalanceRepository;
import design.splitwise.repository.ExpenseRepository;
import design.splitwise.service.BalanceService;
import design.splitwise.service.ExpenseService;
import design.splitwise.service.ReportService;

public class Main {
    public static void main(String[] args) {

        // users and group setup
        User user1 = new User(1, "Vijendra");
        User user2 = new User(2, "Pranshant");
        User user3 = new User(3, "Aayush");
        Group group = new Group(1, "Group : Manage sharing room activities");
        group.addUser(user1);
        group.addUser(user2);
        group.addUser(user3);

        // services setup
        ExpenseRepository expenseRepository = new ExpenseRepository();
        BalanceRepository balanceRepository = new BalanceRepository();
        ResolverFactory resolverFactory = new ResolverFactory();
        BalanceService balanceService = new BalanceService(expenseRepository, resolverFactory, balanceRepository);
        ExpenseService expenseService = new ExpenseService(expenseRepository, balanceService);
        ReportService reportService = new ReportService(balanceService);

        expenseService.addExpense(group, user1, 1200, new PercentageSplitDetail(List.of(new UserPercentage(user2, 25), new UserPercentage(user3, 75))));
        reportService.getReport(user1, group);

        expenseService.addExpense(group, user1, 200, new EqualSplitDetail(List.of(user2, user3)));
        reportService.getReport(user1, group);
        
        expenseService.addExpense(group, user2, 200, new EqualSplitDetail(List.of(user1, user3)));
        reportService.getReport(user1, group);

        // reportService.getReport(user2, group);
        // reportService.getReport(user3, group);
    }
}
