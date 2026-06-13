package design.vending.atm.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design.vending.atm.patterns.DispenseStrategy;

public class Inventory {
    private final Map<Note, Integer> cashStore = new HashMap<>();
    private DispenseStrategy dispenseStrategy;

    public Inventory(DispenseStrategy dispenseStrategy) {
        this.dispenseStrategy = dispenseStrategy;
    }

    public void add(List<Note> notes) {
        notes.forEach(note -> this.cashStore.put(note, this.cashStore.getOrDefault(note, 0) + 1));
    }

    public void get(List<Note> list) {
        list.forEach(note -> this.cashStore.put(note, this.cashStore.get(note) - 1));
    }

    public int noteCount(Note note) {
        return this.cashStore.getOrDefault(note, 0);
    }

    public void dispense(int amount) {
        this.dispenseStrategy.dispense(amount, this);
    }

    public void view() {
        System.out.println("===============Inventory==============");
        int total = 0;
        for (Note note : this.cashStore.keySet()) {
            int totalOfNote = note.getValue() * this.cashStore.get(note);
            System.out.println(note.getValue() + " X " + this.cashStore.get(note) + " = " + totalOfNote);
            total += totalOfNote;
        }

        System.out.println("Total : " + total);
        System.out.println("===============Inventory==============");
    }
}
