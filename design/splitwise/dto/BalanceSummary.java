package design.splitwise.dto;

import java.util.List;

public class BalanceSummary {
    public double balance;
    public List<UserAmount> userAmounts;
    public BalanceSummary(double balance, List<UserAmount> userAmounts) {
        this.balance = balance;
        this.userAmounts = userAmounts;
    }
}
