package design.vending.fnb.src.strategy;

import design.vending.fnb.src.model.CashReserver;

public abstract class HandleCoinsStrategy {
    protected CashReserver cashReserver;
    public HandleCoinsStrategy(CashReserver cashReserver) {
        this.cashReserver = cashReserver;
    }

    public abstract boolean canGiveAmount(int amount);
    public abstract void giveAmount(int amount);
}
