package design.vending.atm.patterns;

import design.vending.atm.model.Inventory;
import design.vending.atm.model.Note;

public class GreedyDispenseStrategy implements DispenseStrategy {
    @Override
    public void dispense(int amount, Inventory inventory) {
        System.out.println("processing GreedyDispenseStrategy......");
        if(!this.canGive(amount, inventory)) {
            throw new RuntimeException("Can't full fill request");
        }

        this.getHandler(inventory).handle(amount);
    }

    public boolean canGive(int amount, Inventory inventory) {
        // it will check starting from high value note and than to lower
        return true;
    }

    public DispenseHandler getHandler(Inventory inventory) {
        DispenseHandler hundredHandler = new NoteDispenseHandler(null, inventory, Note.ONE_HUNDRED);
        DispenseHandler thousandHandler = new NoteDispenseHandler(hundredHandler, inventory, Note.ONE_THOUSAND);
        return thousandHandler;
    }
}
