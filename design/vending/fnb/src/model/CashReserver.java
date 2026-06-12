package design.vending.fnb.src.model;
import java.security.InvalidParameterException;
import java.time.Duration;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CashReserver {
    private Map<Integer, Integer> notes;
    public CashReserver() {
        this.notes = new HashMap<>();
    }

    public void putCoin(Coin coin) {
        int coinValue = coin.getValue();
        notes.put(coinValue, notes.getOrDefault(coinValue, 0) + 1);
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

    private void giveCoins(int value, int number) {
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

    public boolean canGiveAmount(int amount) {
        System.out.println("Request for %d".formatted(amount));
        if(amount < 0) {
            throw new InvalidParameterException("Negative amount !");
        }

        if(amount == 0) return true;

        List<Integer> availableCoins = this.notes.keySet().stream()
            .filter(coin -> this.notes.getOrDefault(coin, 0) > 0)
            .sorted(Comparator.reverseOrder())
            .toList();
        System.out.println(availableCoins);

        int n = amount;
        for (int coin : availableCoins) {
            int needCoinCount = n / coin;
            if(needCoinCount == 0) {
                // coin is greater than n / amount
                continue; // let check next coin
            }

            // let's how many notes are present
            int canGiveCoins = this.getCoinCount(new Coin(coin));
            if(canGiveCoins >= needCoinCount) {
                n = n % coin; // 
                System.out.println("CHECK : Considered All : %d X %d = %d".formatted(coin, needCoinCount, coin * needCoinCount)); // just for
            } else {
                n = n - canGiveCoins * coin;
                System.out.println("CHECK : Only Available : %d X %d = %d".formatted(coin, canGiveCoins, canGiveCoins * coin));
            }
            
            if(n == 0) {
                // yes so no more amount has to be checked further.
                System.out.println("Amount %d can be given.".formatted(amount));
                return true;
            }
        }

        return false;
    }

    public void giveAmount(int amount) {
        if(!this.canGiveAmount(amount)) {
            throw new RuntimeException("Can't fullfill request of Amount : " + amount);
        }

        System.out.println("Cash Reserver processing amount : " + amount);
        
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {}
        
        if(amount == 0) return;

        List<Integer> availableCoins = this.notes.keySet().stream()
            .filter(coin -> this.notes.getOrDefault(coin, 0) > 0)
            .sorted(Comparator.reverseOrder())
            .toList();
        System.out.println(availableCoins);

        int n = amount;
        for (int coin : availableCoins) {
            int needCoinCount = n / coin;
            if(needCoinCount == 0) {
                // coin is greater than n / amount
                continue; // let check if next coin can be given.
            }

            // let's how many notes are present
            int canGiveCoins = this.getCoinCount(new Coin(coin));
            if(canGiveCoins >= needCoinCount) {
                this.giveCoins(coin, needCoinCount); // Telling reserver to reducing
                n = n % coin; // 
                System.out.println("GIVE : Considered All : %d X %d = %d".formatted(coin, needCoinCount, coin * needCoinCount)); // just for
            } else {
                this.giveCoins(coin, canGiveCoins);
                n = n - canGiveCoins * coin;
                System.out.println("GIVE : Only Available : %d X %d = %d".formatted(coin, canGiveCoins, canGiveCoins * coin));
            }
            
            if(n == 0) {
                break;
            }
        }

        System.out.println("Here is the requested AMOUNT : %d.".formatted(amount));
    }

    public void viewReserver() { // only for owner ( as of now just for see what's happening )
        System.out.println("=======================CASH RESERVER===================");
        for (int coin : this.notes.keySet()) {
            System.out.println("Coin : %d, Quanity : %d".formatted(coin, this.notes.get(coin)));
        }

        System.out.println("=======================CASH RESERVER===================");
    }
}
