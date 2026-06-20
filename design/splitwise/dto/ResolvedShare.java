package design.splitwise.dto;

import design.splitwise.model.User;

public class ResolvedShare {
    public User user;
    public double amount;
    public ResolvedShare(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }
}
