package design.vending.fnb.src.model;
import java.time.Duration;
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
        System.out.println("Adding coing to reserver");
        
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {}
        
        // @todo : Pending to be completed the rest
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
        // @todo : Has to be completed ( for now considering that it returns sometime true sometime false)
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

        return true;
    }

    public void giveAmount(int amount) {
        System.out.println("Cash Reserver processing amount : " + amount);
        
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {}
        
        // @todo : Pending to be completed the rest
    }
}
