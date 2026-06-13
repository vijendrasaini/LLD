package design.vending.atm.patterns;

import design.vending.atm.model.Inventory;
import design.vending.atm.model.Note;


public class NoteDispenseHandler implements DispenseHandler {
    private DispenseHandler next;
    private Inventory inventory;
    private Note currentNote;

    public NoteDispenseHandler(DispenseHandler next, Inventory inventory, Note currentNote) {
        this.next = next;
        this.inventory = inventory;
        this.currentNote = currentNote;
    }

    @Override
    public void handle(int amount) {
        int availableCount = inventory.noteCount(this.currentNote);
        int remainingAmount = 0;
        int totalNoteValue = availableCount * this.currentNote.getValue();
        int requiredNoteValueNoteCount = amount / this.currentNote.getValue();
        if(amount <= totalNoteValue) {
            remainingAmount = totalNoteValue - requiredNoteValueNoteCount * this.currentNote.getValue();
            System.out.println("Handed over : " + requiredNoteValueNoteCount * this.currentNote.getValue());
        } else {
            // let's try to give available;
            remainingAmount = amount - totalNoteValue;
            System.out.println("Handed over all 100 : " + totalNoteValue);
        }

        if(remainingAmount == 0) {
            return;
        }

        if(this.next != null) {
            this.next.handle(remainingAmount);
        } else {
            System.out.println("Next handler is not avalable");
        }
    }
}
