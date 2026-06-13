package design.vending.fnbv2.state;

import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Product;
import design.vending.fnb.src.model.Transaction;
import design.vending.fnbv2.Machine;
import design.vending.fnbv2.enums.MachineStatus;

public class HasMoney implements MachineState{

    @Override
    public MachineStatus select(Machine machine, Transaction transaction, SlotCode slotCode, Product product) {
        transaction.select(slotCode, product);
        System.out.println("(HasMoney) : PRODUCT is selected");
        return MachineStatus.HAS_PRODUCT; // user can re select product.
    }

    @Override
    public MachineStatus takeCoins(Machine machine, Transaction transaction, List<Coin> coins) {
        transaction.addCoins(coins);
        return MachineStatus.HAS_MONEY;
    }

    @Override
    public void cancel(Machine machine) {
        System.out.println("(HasMoney) : Cancelling the transaction");
        System.out.println("Refunding the money back to customer");
        machine.refund();
    }

    @Override
    public void dispense(Machine machine) {
        machine.proceed();
    }
}
