package design.splitwise.dto;

import design.splitwise.model.User;

public class UserAmount {
    public User user;
    public double amount;
    public UserAmount(User user, double amount) {
        this.user = user;
        this.amount = amount;
    }
}
