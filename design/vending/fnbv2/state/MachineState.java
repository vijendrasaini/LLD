package design.vending.fnbv2.state;

import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Product;
import design.vending.fnb.src.model.Transaction;
import design.vending.fnbv2.Machine;
import design.vending.fnbv2.enums.MachineStatus;

public interface MachineState {
    MachineStatus select(Machine machine, Transaction transaction, SlotCode slotCode, Product product);
    MachineStatus takeCoins(Machine machine, Transaction transaction, List<Coin> coins);
    void cancel(Machine machine);
    void dispense(Machine machine);
}
