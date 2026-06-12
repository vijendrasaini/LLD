package design.vending.fnb.src.model;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design.vending.fnb.src.enums.SlotCode;

public class Inventory {
    private Map<SlotCode, Slot> slots;

    public Inventory() {
        this.slots = new HashMap<>();
    }

    public void addSlot(SlotCode code, Slot slot) {
        slots.put(code, slot);
    }

    public void viewInventory() {
        for (SlotCode code : this.slots.keySet()) {
            System.out.println(code + " : " + this.slots.get(code));
        }
    }

    public void showProducts() {
        for (SlotCode slotCode : this.slots.keySet()) {
            Slot slot = this.slots.get(slotCode);
            if(slot.getQuantity() > 0) {
                System.out.println("---------------------------------------------");
                System.out.println("Code : " + slotCode);
                slot.showProduct();
            }
        }

        System.out.println();
    }

    public Product getProduct(SlotCode slotCode) {
        return this.slots.get(slotCode).getProduct();
    }

    public void reduceQuantityByOne(SlotCode slotCode) {
        System.out.println("Reducing Quanity by One");
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {}
        
        this.slots.get(slotCode).reduceQuantityByOne();
    }
}
