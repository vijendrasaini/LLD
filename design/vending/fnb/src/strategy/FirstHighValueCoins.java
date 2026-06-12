package design.vending.fnb.src.strategy;

import java.security.InvalidParameterException;
import java.time.Duration;
import java.util.List;

import design.vending.fnb.src.model.CashReserver;
import design.vending.fnb.src.model.Coin;

public class FirstHighValueCoins extends HandleCoinsStrategy{
    public FirstHighValueCoins(CashReserver cashReserver) {
        super(cashReserver);
    }

    @Override
    public boolean canGiveAmount(int amount) {
        System.out.println("Request for %d".formatted(amount));
        if(amount < 0) {
            throw new InvalidParameterException("Negative amount !");
        }

        if(amount == 0) return true;

        List<Integer> availableCoins = this.cashReserver.getAvailableCoins();
        System.out.println(availableCoins);

        int n = amount;
        for (int coin : availableCoins) {
            int needCoinCount = n / coin;
            if(needCoinCount == 0) {
                // coin is greater than n / amount
                continue; // let check next coin
            }

            // let's how many notes are present
            int canGiveCoins = this.cashReserver.getCoinCount(new Coin(coin));
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

    @Override
    public void giveAmount(int amount) {
        if(!this.canGiveAmount(amount)) {
            throw new RuntimeException("Can't fullfill request of Amount : " + amount);
        }

        System.out.println("Cash Reserver processing amount : " + amount);
        
        try {
            Thread.sleep(Duration.ofSeconds(1));
        } catch (Exception e) {}
        
        if(amount == 0) return;

        List<Integer> availableCoins = this.cashReserver.getAvailableCoins();
        System.out.println(availableCoins);

        int n = amount;
        for (int coin : availableCoins) {
            int needCoinCount = n / coin;
            if(needCoinCount == 0) {
                // coin is greater than n / amount
                continue; // let check if next coin can be given.
            }

            // let's how many notes are present
            int canGiveCoins = this.cashReserver.getCoinCount(new Coin(coin));
            if(canGiveCoins >= needCoinCount) {
                this.cashReserver.giveCoins(coin, needCoinCount); // Telling reserver to reducing
                n = n % coin; // 
                System.out.println("GIVE : Considered All : %d X %d = %d".formatted(coin, needCoinCount, coin * needCoinCount)); // just for
            } else {
                this.cashReserver.giveCoins(coin, canGiveCoins);
                n = n - canGiveCoins * coin;
                System.out.println("GIVE : Only Available : %d X %d = %d".formatted(coin, canGiveCoins, canGiveCoins * coin));
            }
            
            if(n == 0) {
                break;
            }
        }

        System.out.println("Here is the requested AMOUNT : %d.".formatted(amount));
    }
    
}
