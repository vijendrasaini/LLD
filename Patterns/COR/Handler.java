package Patterns.COR;

public abstract class Handler {
    protected final int noteValue;
    protected Handler nextHandler = null;
    protected int totalNotes;
    public Handler(int noteValue, Handler nextHandler) {
        this.nextHandler = nextHandler;
        this.noteValue = noteValue;
    }

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void setTotalNotes(int totalNotes) {
        this.totalNotes = totalNotes;
    }

    public void handle(int amount) {
        if(noteValue == 0) {
            throw new ArithmeticException("Devision by zero");
        }

        System.out.println();
        int requiredNotes = amount / noteValue;
        int remainingAmount = amount;
        if(requiredNotes >= totalNotes) {
            if(totalNotes > 0) {
                System.out.println("Dispencing " + (totalNotes) + " * " + noteValue + " amount...");
            }
            requiredNotes -= totalNotes;
            remainingAmount = amount - totalNotes * noteValue;
            
            totalNotes = 0;
        } else {
            if(requiredNotes > 0) {
                System.out.println("Dispencing " + requiredNotes + " * " + noteValue + " amount...");
            }

            totalNotes -= requiredNotes;
            remainingAmount = amount - requiredNotes * noteValue;
        }
        
        if(remainingAmount > 0) {
            if(nextHandler != null) {
                nextHandler.handle(remainingAmount);
                return;
            }
            
            System.out.println("Remaining amount " + remainingAmount);
            System.out.println("Request can't be fullfilled further.");
        }
    }
}
