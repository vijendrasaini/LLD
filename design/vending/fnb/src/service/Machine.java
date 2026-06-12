package design.vending.fnb.src.service;

import java.time.Duration;
import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.enums.Status;
import design.vending.fnb.src.model.CashReserver;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Inventory;
import design.vending.fnb.src.model.Transaction;

public class Machine {
    private Inventory inventory;
    private Transaction currentTransaction;
    private CashReserver cashReserver;
    private Status status;

    public Machine(Inventory inventory, CashReserver cashReserver) {
        this.inventory = inventory;
        this.cashReserver = cashReserver;
        this.status = Status.IDLE;
    }
    
    public void showProducts() {
        // delegates to inventory
        inventory.showProducts();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void selectProduct(SlotCode code) {
        this.setStatus(Status.OPEN_TO_QUERIES);
        this.getTransaction().select(code, this.inventory.getProduct(code));
    }

    public void takeCoins(List<Coin> coins) {
        this.getTransaction().addCoins(coins);
    }

    public boolean canCustomerTakeAction() {
        if(List.of(Status.PROCESSING_TRANSACTION).contains(this.status)) {
            return false;
        }

        return true;
    }

    public void submit() {
        try {
            if(canCustomerTakeAction()) {
                this.setStatus(Status.INITIATING_TRANSACTION);
                
                this.getTransaction().validate();
                
                this.setStatus(Status.PROCESSING_TRANSACTION);
        
                this.canGiveChange();
        
                this.completeTransaction();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            this.setStatus(Status.OPEN_TO_QUERIES);
        }
    }

    public void canGiveChange() {
        boolean canGiveAmount = this.cashReserver.canGiveAmount(this.getTransaction().getChange());
        if(!canGiveAmount) {
            this.setStatus(Status.OPEN_TO_QUERIES);
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
        // clearing currnet transacition
        this.currentTransaction = null;
        this.setStatus(Status.IDLE);
        System.out.println("Your transaction is completed. Thanks for your time !!!");
    }

    public void dispense() {
        System.out.println();
        System.out.println("============Dispensing started============");

        // just to replicate real life case
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {}

        System.out.println("============Successfully Handed Over.============");
    }
}
