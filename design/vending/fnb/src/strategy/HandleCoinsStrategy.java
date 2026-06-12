package design.vending.fnb.src.strategy;

import design.vending.fnb.src.model.CashReserver;

public interface HandleCoinsStrategy {
    boolean canGiveAmount(CashReserver cashReserver, int amount);
    void giveAmount(CashReserver cashReserver, int amount);
}
