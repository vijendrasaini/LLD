package design.vending.atm.model;

public enum Note {
    ONE_HUNDRED(100),
    FIVE_HUNDRED(500),
    ONE_THOUSAND(1000),
    TWO_THOUSAND(2000);

    private int value;
    private Note(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
