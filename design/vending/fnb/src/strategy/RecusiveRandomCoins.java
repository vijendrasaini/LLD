package design.vending.fnb.src.strategy;
import java.util.List;

import design.vending.fnb.src.model.CashReserver;

public class RecusiveRandomCoins extends HandleCoinsStrategy{
    public RecusiveRandomCoins(CashReserver cashReserver) {
        super(cashReserver);
    }

    @Override
    public boolean canGiveAmount(int amount) {
        List<Integer> availableCoins = this.cashReserver.getAvailableCoins();
        if(availableCoins.size() == 0 ) return false;

        return canGiveRecurrsive(amount, this.cashReserver.getAvailableCoins(), 0);
    }

    private boolean canGiveRecurrsive(int amount, List<Integer> coins, int coinIndex) {
        if(amount == 0) {
            return true;
        }

        // @todo 
        // take or don't take ( also coin count needs to keep in mind. we have sufficient count supply )

        return false;
    }

    @Override
    public void giveAmount(int amount) {
        // @todo take or don't take ( also coin count needs to keep in mind. we have sufficient count supply )
    }
}
