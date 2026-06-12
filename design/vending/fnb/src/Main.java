package design.vending.fnb.src;

import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.model.CashReserver;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Inventory;
import design.vending.fnb.src.model.Product;
import design.vending.fnb.src.model.Slot;
import design.vending.fnb.src.service.Machine;

public class Main {
    public static void main(String[] args) {
        Product candy = new Product("5 start", 5, "5-start-candy-image");
        Slot candySlot = new Slot(10, candy);
    
        Product waterBottle = new Product("Bislery", 100, "bislery-image");
        Slot waterSlot = new Slot(10, waterBottle);
    
        Product kurkure = new Product("KurKure", 10, "kur-kure-photo");
        Slot kurkureSlot = new Slot(1, kurkure);
    
        Inventory inventory = new Inventory();
        CashReserver cashReserver = new CashReserver();
        inventory.addSlot(SlotCode.CANDY, candySlot);
        inventory.addSlot(SlotCode.WATER, waterSlot);
        inventory.addSlot(SlotCode.CHILPS, kurkureSlot);

        Machine machine = new Machine(inventory, cashReserver);

        Coin coinFifty = new Coin(50);
        Coin coinTen = new Coin(10);
        Coin coinFive = new Coin(5);

        // user comes
        // 1. user selects view products command
        machine.showProducts();

        // 2. user select a product i.e. Candy
        machine.selectProduct(SlotCode.CANDY);

        // 3. user insserting coins
        machine.takeCoins(List.of(coinFive));

        // 4. user submitted request to machine
        machine.submit();
    }
}
