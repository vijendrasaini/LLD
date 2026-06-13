package design.vending.atm.service;


import design.vending.atm.State.IdleState;
import design.vending.atm.State.State;
import design.vending.atm.model.Card;
import design.vending.atm.model.Inventory;
import design.vending.atm.model.Session;

public class ATM {
    private Inventory inventory;
    private State state;
    private Session session;
    private WithdrawService withdrawService;

    public ATM(Inventory inventory) {
        this.inventory = inventory;
        this.state = new IdleState();
        this.withdrawService = new WithdrawService(inventory);
    }

    public void createSession(Card card) {
        this.session = new Session(card);
    }

    public void removeSession() {
        this.session = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCard(Card card) {
        this.state.insertCard(this, card);
    }

    public void validatePin(String pin) {
        this.state.validatePin(this, pin);
    }

    public void validatePinInternal(String pin) {
        // let's say pin is valid
        this.session.setAuthenticated(true);
    }

    public void withdraw(int amount) {
        this.state.withdraw(this, amount);
    }

    public void withdrawInternal(int amount) {
        this.session.setAmount(amount);
        
        this.withdrawService.withdraw(this.session);
    }

    public void ejectCard() {
        System.out.println("Thanks for using our service!");
        System.out.println("Please collect your card!");
        this.setState(new IdleState());
    }

    public void cancel() {
        this.state.cancelSession(this);
    }
}
