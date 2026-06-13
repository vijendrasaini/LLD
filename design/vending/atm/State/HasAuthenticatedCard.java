package design.vending.atm.State;

import design.vending.atm.model.Card;
import design.vending.atm.service.ATM;

public class HasAuthenticatedCard implements State {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is already there!");
    }

    @Override
    public void validatePin(ATM atm, String pin) {
        System.out.println("Already verified!");
    }

    @Override
    public void withdraw(ATM atm, int amount) {
        atm.withdrawInternal(amount);
        atm.ejectCard();
        atm.setState(new IdleState());
    }

    @Override
    public void cancelSession(ATM atm) {
        atm.removeSession();
        atm.ejectCard();
        atm.setState(new IdleState());
        System.out.println("Please insert your card again if you want to withdraw!");
    }
}
