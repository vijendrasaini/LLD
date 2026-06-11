package design.vending.fnb.src.model;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashReserver {
    private Map<Integer, Integer> notes;
    public CashReserver() {
        this.notes = new HashMap<>();
    }

    public void putCoin(Coin coin) {
        notes.put(coin.getValue(), notes.getOrDefault(coin, 0) + 1);
    }

    public void putCoins(List<Coin> coins) {
        // @todo
    }

    public void updateCoinByNumber(Coin coin, int number) {
        int currentCount = notes.getOrDefault(coin, 0);
        if(currentCount - number >= 0)
        this.notes.put(coin.getValue(),  - number);
    }

    public int getCoinCount(Coin coin) {
        return this.notes.getOrDefault(coin, 0);
    }

    public boolean canGiveCoins(Coin coin, int number) {
        return notes.getOrDefault(coin, 0) - number >= 0;
    }

    public boolean canGiveAmount(int amount) {
        // @todo : Has to be completed ( for now considering that it)
        // List<Integer> availableCoins = this.notes.keySet().stream()
        //     .filter(coin -> this.notes.getOrDefault(coin, 0) > 0)
        //     .sorted(Comparator.reverseOrder())
        //     .toList();

        // for (int coin : availableCoins) {
        //     if(coin > amount) {
        //         continue;
        //     }

        //     int n = amount / coin;
        //     int remainingAmount = amount % coin;
        // }

        return false;
    }
}
