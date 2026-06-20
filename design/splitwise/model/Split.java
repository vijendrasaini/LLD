package design.splitwise.model;

public class Split {
    private User user;
    private double value;
    public Split(User user, double value) {
        this.user = user;
        this.value = value;
    }
    

    public User getUser() {
        return user;
    }
}
