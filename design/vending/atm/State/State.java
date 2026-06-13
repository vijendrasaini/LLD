package design.vending.atm.State;

import design.vending.atm.model.Card;
import design.vending.atm.service.ATM;

public interface State {
    void insertCard(ATM atm, Card card);
    void validatePin(ATM atm, String pin);
    void withdraw(ATM atm, int amount);
    void cancelSession(ATM atm);
}
