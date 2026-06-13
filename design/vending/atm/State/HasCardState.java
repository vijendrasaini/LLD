package design.vending.atm.State;

import design.vending.atm.model.Card;
import design.vending.atm.service.ATM;

public class HasCardState implements State {

    @Override
    public void cancelSession(ATM atm) {
        atm.removeSession();
        atm.ejectCard();
        atm.setState(new IdleState());
        System.out.println("Please insert your card again if you want to withdraw!");
    }

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Doesn't make sense");
        
    }

    @Override
    public void validatePin(ATM atm, String pin) {
        atm.validatePinInternal(pin);
        atm.setState(new HasAuthenticatedCard());
        System.out.println("Please enter the amount ....");
    }

    @Override
    public void withdraw(ATM atm, int amount) {
        System.out.println("Please provide pin");
    }
}
