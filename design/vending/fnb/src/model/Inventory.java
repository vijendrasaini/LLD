package design.vending.fnb.src.model;

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
    }
}
