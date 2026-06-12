package design.vending.fnb.src;

import java.util.List;

import design.vending.fnb.src.enums.SlotCode;
import design.vending.fnb.src.model.CashReserver;
import design.vending.fnb.src.model.Coin;
import design.vending.fnb.src.model.Inventory;
import design.vending.fnb.src.model.Product;
import design.vending.fnb.src.model.Slot;
import design.vending.fnb.src.service.Machine;
import design.vending.fnb.src.strategy.FirstHighValueCoins;
import design.vending.fnb.src.strategy.HandleCoinsStrategy;

public class Main {
    public static void main(String[] args) {
        Product candy = new Product("5 start", 5, "5-start-candy-image");
        Slot candySlot = new Slot(10, candy);
    
        Product waterBottle = new Product("Bislery", 100, "bislery-image");
        Slot waterSlot = new Slot(10, waterBottle);
    
        Product kurkure = new Product("KurKure", 10, "kur-kure-photo");
        Slot kurkureSlot = new Slot(1, kurkure);
    
        Inventory inventory = new Inventory();
        inventory.addSlot(SlotCode.CANDY, candySlot);
        inventory.addSlot(SlotCode.WATER, waterSlot);
        inventory.addSlot(SlotCode.CHILPS, kurkureSlot);

        Coin coin50 = new Coin(50);
        Coin coin20 = new Coin(20);
        Coin coin10 = new Coin(10);
        Coin coin5 = new Coin(5);
        Coin coin2 = new Coin(2);
        Coin coin1 = new Coin(1);
        
        CashReserver cashReserver = new CashReserver();
        cashReserver.setHandleCoinsStrategy(new FirstHighValueCoins(cashReserver));
        // adding few coins to the Reserver at starting of the program to test 
        // 50 : 1, 20 : 1, 10 : 2, 5 : 2, 2 : 1, 1 : 5
        cashReserver.putCoins(List.of(
            coin50, 
            coin20, 
            coin10, coin10, 
            coin5, coin5, 
            coin2, 
            coin1, coin1, coin1, coin1, coin1
        ));

        // testing
        // Test : Check 1000
        // cashReserver.canGiveAmount(1000); // working as expected

        // Test : Take 100
        // cashReserver.viewReserver();
        // cashReserver.giveAmount(100); // working as expected
        // cashReserver.viewReserver();

        // Test : Take 33
        // cashReserver.viewReserver();
        // cashReserver.giveAmount(33); // working as expected
        // cashReserver.viewReserver();



        Machine machine = new Machine(inventory, cashReserver);

        
        // user comes
        // 1. user selects view products command
        machine.showProducts();

        // 2. user select a product i.e. Candy
        machine.selectProduct(SlotCode.CANDY);

        // 3. user insserting coins
        machine.takeCoins(List.of(coin50));

        // 4. user submitted request to machine
        machine.submit();
    }
}
