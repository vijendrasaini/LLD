package design.splitwise.model;
public class Expense {
    private int id;
    private double amount;
    private User paidByUser;
    private Group group;
    private SplitDetail splitDetail;

    public Expense(double amount, User paidByUser, Group group, SplitDetail splitDetail) {
        this.amount = amount;
        this.paidByUser = paidByUser;
        this.group = group;
        this.splitDetail = splitDetail;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidByUser;
    }

    public Group getGroup() {
        return group;
    }

    public SplitDetail getSplitDetail() {
        return splitDetail;
    }

    public void setId(int id) {
        this.id = id;
    }
}
