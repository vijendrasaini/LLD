package design.splitwise.model;

import java.util.List;

public class Expense {
    private int id;
    private double amount;
    private int paidBy;
    private int groupId;
    private List<Integer> participantIds;

    public Expense(int id, double amount, int paidBy, int groupId, List<Integer> participantIds) {
        this.id = id;
        this.amount = amount;
        this.paidBy = paidBy;
        this.groupId = groupId;
        this.participantIds = participantIds;
    }

    public double getAmount() {
        return amount;
    }

    public int getPaidBy() {
        return paidBy;
    }

    public int getGroupId() {
        return groupId;
    }
}
