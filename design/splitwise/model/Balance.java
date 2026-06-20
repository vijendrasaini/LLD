package design.splitwise.model;

public class Balance {
    public int id;
    private Group group;
    private User creditor;
    private User debtor;
    private double amount;

    public Balance(Group group, User creditor, User debtor, double amount) {
        this.group = group;
        this.creditor = creditor;
        this.debtor = debtor;
        this.amount = amount;
    }

    public User getCreditor() {
        return creditor;
    }

    public User getDebtor() {
        return debtor;
    }

    public Group getGroup() {
        return group;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCreditor(User creditor) {
        this.creditor = creditor;
    }

    public void setDebtor(User debtor) {
        this.debtor = debtor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
