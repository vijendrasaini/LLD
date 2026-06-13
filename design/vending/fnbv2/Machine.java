package design.vending.fnbv2;

import java.time.Duration;
import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.model.CashReserver;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Inventory;
import design.vending.fnb.src.model.Transaction;
import design.vending.fnbv2.enums.MachineStatus;
import design.vending.fnbv2.state.MachineState;

public class Machine {
    private Inventory inventory;
    private Transaction currentTransaction;
    private CashReserver cashReserver;
    private MachineStatus status;
    private MachineStateFactory machineStateFactory;

    public Machine(Inventory inventory, CashReserver cashReserver, MachineStateFactory machineStateFactory) {
        this.inventory = inventory;
        this.cashReserver = cashReserver;
        this.status = MachineStatus.IDLE;
        this.machineStateFactory = machineStateFactory;
    }

    private Transaction getTransaction() {
        if(this.currentTransaction == null) {
            this.currentTransaction = new Transaction();
        }
        
        return this.currentTransaction;
    }

    public void showProducts() {
        inventory.showProducts();
    }

    public void setStatus(MachineStatus status) {
        this.status = status;
    }

    private MachineState getMachineState() {
        return this.machineStateFactory.getMachineState(this.status);
    }

    public void select(SlotCode code) {
        this.status = this.getMachineState().select(this, this.getTransaction(), code, this.inventory.getProduct(code));
    }

    public void takeCoins(List<Coin> coins) {
        this.status = this.getMachineState().takeCoins(this, this.getTransaction(), coins);
    }

    public void cancel() {
        this.getMachineState().cancel(this);
    }

    public void removeTransaction() {
        System.out.println("Transation has been removed Successfully");
        this.currentTransaction = null;
        this.status = MachineStatus.IDLE;
    }

    public void submit() {
        this.getMachineState().dispense(this);
    }

    public void proceed() {
        this.getTransaction().validate();
        
        this.canGiveChange();

        this.completeTransaction();
    }

    public void refund() {
        this.cashReserver.giveAmount(this.getTransaction().getTotalAmount());
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

    private void updateScreen() {
        System.out.println("Your transaction is completed. Thanks for your time !!!");
        this.status = MachineStatus.IDLE;
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
