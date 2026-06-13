package design.vending.atm.State;

import design.vending.atm.model.Card;
import design.vending.atm.service.ATM;

public class IdleState implements State {

    @Override
    public void insertCard(ATM atm, Card card) {
        atm.createSession(card);
        atm.setState(new HasCardState());
        System.out.println("Please enter your PIN now...");
    }

    @Override
    public void validatePin(ATM atm, String pin) {
        System.out.println("Please insert Card First");
    }

    @Override
    public void withdraw(ATM atm, int amount) {
        System.out.println("Please insert Card First");
    }

    @Override
    public void cancelSession(ATM atm) {
        System.out.println("Please insert Card First");
    }    
}
