package model;

import enums.SplitType;

public abstract class Split {
    private User user;
    private double amount;
    private SplitType splitType;

    public Split(User user, double amount, SplitType splitType) {
        this.user = user;
        this.amount = amount;
        this.splitType = splitType;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public User getUser() {
        return user;
    }

    public double getAmount() {
        return amount;
    }
}
