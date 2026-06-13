package design.vending.fnbv2.state;

import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Product;
import design.vending.fnb.src.model.Transaction;
import design.vending.fnbv2.Machine;
import design.vending.fnbv2.enums.MachineStatus;

public class IdleState implements MachineState {

    @Override
    public MachineStatus select(Machine machine, Transaction transaction, SlotCode slotCode, Product product) {
        transaction.select(slotCode, product);
        System.out.println("(IdleState) : PRODUCT is selected");
        return MachineStatus.HAS_PRODUCT;
    }

    @Override
    public MachineStatus takeCoins(Machine machine, Transaction transaction, List<Coin> coins) {
        System.out.println("(IDLE)");
        return MachineStatus.IDLE;
    }

    @Override
    public void cancel(Machine machine) {
        System.out.println("(IDLE)");
    }

    @Override
    public void dispense(Machine machine) {
        System.out.println("(IDLE)");
    }
}
