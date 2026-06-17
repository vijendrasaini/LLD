package design.splitwise.model;

import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private double amount;
    private int createdBy;
    private int groupId;
    private LocalDateTime createdAt;

    public Transaction(int id, double amount, int createdBy, int groupId) {
        this.id = id;
        this.amount = amount;
        this.createdBy = createdBy;
        this.groupId = groupId;
        this.createdAt = LocalDateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public int getGroupId() {
        return groupId;
    }
}
