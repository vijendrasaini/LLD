package design.splitwise.dto;

import design.splitwise.model.User;

public class UserPercentage {
    public User user;
    public int percentage;
    public UserPercentage(User user, int percentage) {
        this.user = user;
        this.percentage = percentage;
    }
}
