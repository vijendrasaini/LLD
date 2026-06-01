package Patterns.COR;

public abstract class Handler {
    protected final int noteValue;
    protected int totalNotes;
    protected final Handler nextHandler;

    public Handler(int noteValue, int totalNotes, Handler nextHandler) {
        if (noteValue <= 0) {
            throw new IllegalArgumentException("noteValue must be greater than zero");
        }
        this.noteValue = noteValue;
        this.totalNotes = totalNotes;
        this.nextHandler = nextHandler;
    }

    public int getNoteValue() {
        return noteValue;
    }

    public int getTotalNotes() {
        return totalNotes;
    }

    public void handle(int amount) {
        if (amount <= 0) {
            System.out.println("No amount to dispense.");
            return;
        }

        int dispensableNotes = Math.min(amount / noteValue, totalNotes);
        if (dispensableNotes > 0) {
            System.out.println("Dispensing " + dispensableNotes + " x " + noteValue + " note(s)");
            totalNotes -= dispensableNotes;
        }

        int remainingAmount = amount - dispensableNotes * noteValue;
        if (remainingAmount > 0) {
            if (nextHandler != null) {
                nextHandler.handle(remainingAmount);
                return;
            }
            System.out.println("Remaining amount " + remainingAmount + " cannot be fulfilled.");
        }
    }
}
