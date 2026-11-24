package service;

import factory.SplitStrategyFactory;
import model.Group;
import model.Split;
import model.User;
import strategy.SplitStrategy;

import java.util.Map;

public class ExpenseManager {
    private final BalanceManager balanceManager;
    public ExpenseManager(BalanceManager balanceManager) {
        this.balanceManager = balanceManager;
    }

    public void addSplit(Split split, Group group) {
        SplitStrategy splitStrategy = SplitStrategyFactory.get(split.getSplitType());

        if(!splitStrategy.validateSplit(split)) {
            throw new RuntimeException("Invalid split");
        }

        Map<User, Double> splitAmounts = splitStrategy.calculateSplitAmounts(split, group);

        Map<User, Double> payerBalana = group.getUserBalance(split.getUser());
        for (User user: splitAmounts.keySet()) {
            double amountToBeAdded = splitAmounts.get(user);

            balanceManager.settle(split.getUser(), user, group, amountToBeAdded);
        }
    }
}
