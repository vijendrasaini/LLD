package design.splitwise.service;

import design.splitwise.dto.BalanceSummary;
import design.splitwise.dto.UserAmount;
import design.splitwise.model.Group;
import design.splitwise.model.User;

public class ReportService {
    private BalanceService balanceService;
    public ReportService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    public void getReport(User user, Group group) {
        System.out.println();
        System.out.println("Group : %s, User : %s".formatted(group.getName(), user));

        BalanceSummary balanceSummary = balanceService.getBalance(user, group);
        System.out.println("User's total : " + balanceSummary.balance);
        System.out.println("Money to be received / Given: ");
        for (UserAmount userAmount : balanceSummary.userAmounts) {
            if(userAmount.amount >= 0) {
                System.out.println("Amount: %f to be received from User: %s".formatted(Math.abs(userAmount.amount), userAmount.user));
            } else {
                System.out.println("Amont: %f to be given to User: %s".formatted(Math.abs(userAmount.amount), userAmount.user));
            }
        }
    }
}
