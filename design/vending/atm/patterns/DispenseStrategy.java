package design.vending.atm.patterns;

import design.vending.atm.model.Inventory;

public interface DispenseStrategy {
    public void dispense(int amount, Inventory inventory);
}
