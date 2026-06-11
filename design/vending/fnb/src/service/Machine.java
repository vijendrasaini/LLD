package design.vending.fnb.src.service;

import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Inventory;
import design.vending.fnb.src.model.Product;
import design.vending.fnb.src.model.Transaction;

public class Machine {
    private Inventory inventory;
    private SlotCode selectedCode;

    public Machine(Inventory inventory) {
        this.inventory = inventory;
    }
    
    public void showProducts() {
        // delegates to inventory
        inventory.showProducts();
    }

    public void selectProduct(SlotCode code) {
        this.selectedCode = code;
    }

    public void takeCoins(List<Coin> coins) {

    }

    public void submit() {

    }

    private Transaction createTransaction() {
        return new Transaction();
    }
}
