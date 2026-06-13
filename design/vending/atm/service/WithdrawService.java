package design.vending.atm.service;

import design.vending.atm.model.Card;
import design.vending.atm.model.Inventory;
import design.vending.atm.model.Session;

public class WithdrawService {
    private Inventory inventory;

    WithdrawService(Inventory inventory) {
        this.inventory = inventory;
    }

    public void withdraw(Session session) {
        this.validateAmount(session.getAmount());

        this.checkSufficientBalance(session);

        inventory.dispense(session.getAmount());
    }

    public void validateAmount(int amount) {
        System.out.println("Amount is greater than 0!");
    }
    
    public void checkSufficientBalance(Session session) {
        System.out.println("Card has sufficient amount!");
    }
}
