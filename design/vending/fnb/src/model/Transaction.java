package design.vending.fnb.src.model;

import java.util.ArrayList;
import java.util.List;

import design.vending.fnb.src.enums.SlotCode;

public class Transaction {
    private SlotCode slotCode;
    private Product product;
    private List<Coin> coins;
    public Transaction() {
        this.coins = new ArrayList<>();
    }

    public void select(SlotCode slotCode, Product product) {
        this.slotCode = slotCode;
        this.product = product;
    }

    public void addCoins(List<Coin> coins) {
        for (Coin coin : coins) {
            System.out.println(coin.getValue());
            this.coins.add(coin);
        }
    }

    public void validate() {
        int productPrice = this.product.getPrice();
        int totalAmount = this.getTotalAmount();
        if(totalAmount < productPrice) {
            throw new RuntimeException("Insufficient coins! Required amount ( %d - %d ) = %d".formatted(productPrice, totalAmount, productPrice - totalAmount));
        }
    }

    public int getTotalAmount() {
        return this.coins.stream()
        .mapToInt(coin -> coin.getValue())
        .sum();
    }

    public SlotCode getSlotCode() {
        return slotCode;
    }

    public int getChange() {
        return this.getTotalAmount() - this.product.getPrice();
    }

    public List<Coin> getCoins() {
        return new ArrayList<>(this.coins);
    }
}
