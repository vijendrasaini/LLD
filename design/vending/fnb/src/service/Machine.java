package design.vending.fnb.src.service;

import java.time.Duration;
import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.model.CashReserver;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Inventory;
import design.vending.fnb.src.model.Transaction;

public class Machine {
    private Inventory inventory;
    private Transaction currentTransaction;
    private CashReserver cashReserver;

    public Machine(Inventory inventory, CashReserver cashReserver) {
        this.inventory = inventory;
        this.cashReserver = cashReserver;
    }
    
    public void showProducts() {
        // delegates to inventory
        inventory.showProducts();
    }

    public void selectProduct(SlotCode code) {
        this.getTransaction().select(code, this.inventory.getProduct(code));
    }

    public void takeCoins(List<Coin> coins) {
        this.getTransaction().addCoins(coins);
    }

    public void submit() {
        this.getTransaction().validate();
        
        this.canGiveChange();

        this.completeTransaction();
    }

    public void canGiveChange() {
        boolean canGiveAmount = this.cashReserver.canGiveAmount(this.getTransaction().getChange());
        if(!canGiveAmount) {
            throw new RuntimeException("Can't give change. Could process your request. Please reinitiate the request");
        }
    }
    
    private void completeTransaction() {
        // This method will run in a transaction ( atomic way ) either will process all sub calls or won't do anything in production.

        // tell inventory to update
        this.inventory.reduceQuantityByOne(this.getTransaction().getSlotCode());

        // tell Cash reserver to proceed for the change
        this.cashReserver.giveAmount(this.getTransaction().getChange());

        // tell Dispenser to dispense product
        this.dispense();

        // tell Cash Reserver to put the money
        this.cashReserver.putCoins(this.getTransaction().getCoins());

        // tell screen to show transaction complete info
        this.updateScreen();
    }

    private Transaction getTransaction() {
        if(this.currentTransaction == null) {
            this.currentTransaction = new Transaction();
        }
        
        return this.currentTransaction;
    }

    private void updateScreen() {
        System.out.println("Your transaction is completed. Thanks for your time !!!");
    }

    public void dispense() {
        System.out.println("Dispensing selected product");

        // just to replicate real life case
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {}

        System.out.println("Here is your selected Product.");
    }
}
