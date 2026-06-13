package design.vending.atm.model;

public class Session {
    private Card card;
    private boolean isAuthenticated;
    private int amount;

    public Session(Card card) {
        this.card = card;
    }

    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Card getCard() {
        return card;
    }

    public int getAmount() {
        return amount;
    }
}
