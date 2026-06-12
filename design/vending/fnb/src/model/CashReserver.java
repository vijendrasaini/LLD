package design.vending.fnb.src.model;
import java.security.InvalidParameterException;
import java.time.Duration;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design.vending.fnb.src.strategy.HandleCoinsStrategy;

public class CashReserver {
    private Map<Integer, Integer> notes;
    private HandleCoinsStrategy handleCoinsStrategy;
    public CashReserver(HandleCoinsStrategy handleCoinsStrategy) {
        this.handleCoinsStrategy = handleCoinsStrategy;
        this.notes = new HashMap<>();
    }

    public void putCoin(Coin coin) {
        int coinValue = coin.getValue();
        notes.put(coinValue, notes.getOrDefault(coinValue, 0) + 1);
    }

    public void setHandleCoinsStrategy(HandleCoinsStrategy handleCoinsStrategy) {
        this.handleCoinsStrategy = handleCoinsStrategy;
    }

    public void putCoins(List<Coin> coins) {
        System.out.println("Processing list of coins");
        
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {}
        
        for (Coin coin : coins) {
            this.putCoin(coin);
        }
    }

    public void giveCoins(int value, int number) {
        if(this.notes.get(value) < number) {
            throw new RuntimeException("Can't give %d Coin(s) of %d".formatted(number, value));
        }

        this.notes.put(value, this.notes.get(value) - number);
    }

    public int getCoinCount(Coin coin) {
        return this.notes.getOrDefault(coin.getValue(), 0);
    }

    public boolean canGiveCoins(Coin coin, int number) {
        return notes.getOrDefault(coin, 0) - number >= 0;
    }

    public List<Integer> getAvailableCoins() {
        return this.notes.keySet().stream()
            .filter(coin -> this.notes.getOrDefault(coin, 0) > 0)
            .sorted(Comparator.reverseOrder())
            .toList();
    }
    public boolean canGiveAmount(int amount) {
        return this.handleCoinsStrategy.canGiveAmount(this, amount);
    }

    public void giveAmount(int amount) {
        this.handleCoinsStrategy.giveAmount(this, amount);
    }

    public void viewReserver() { // only for owner ( as of now just for see what's happening )
        System.out.println("=======================CASH RESERVER===================");
        for (int coin : this.notes.keySet()) {
            System.out.println("Coin : %d, Quanity : %d".formatted(coin, this.notes.get(coin)));
        }

        System.out.println("=======================CASH RESERVER===================");
    }
}
