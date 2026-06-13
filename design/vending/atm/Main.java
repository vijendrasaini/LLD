package design.vending.atm;

import java.util.List;

import design.vending.atm.model.Card;
import design.vending.atm.model.Inventory;
import design.vending.atm.model.Note;
import design.vending.atm.patterns.DispenseStrategy;
import design.vending.atm.patterns.GreedyDispenseStrategy;
import design.vending.atm.service.ATM;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DispenseStrategy dispenseStrategy = new GreedyDispenseStrategy();
        Inventory inventory = new Inventory(dispenseStrategy);
        // let's insert some notes
        inventory.add(List.of(Note.ONE_HUNDRED, Note.ONE_THOUSAND));
        inventory.view();


        ATM atm = new ATM(inventory);

        // Case - 1
        // atm.cancel();
        // atm.withdraw(1000);
        // atm.validatePin("1234");

        // Case - 2
        // atm.insertCard(new Card(111122223333L));
        // atm.cancel();

        // Case - 3
        // atm.insertCard(new Card(111122223333L));
        // atm.validatePin("1234");
        // atm.cancel();
        // atm.cancel();
        
        // Case - 4
        atm.insertCard(new Card(111122223333L));
        Thread.sleep(1000); // using just for real life time feel
        atm.validatePin("1234");
        Thread.sleep(1000); // using just for real life time feel
        atm.withdraw(1100);
        
    }
}
