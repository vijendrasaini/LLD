package design.vending.fnb.src.model;

import java.util.ArrayList;
import java.util.List;

import design.vending.fnb.src.enums.SlotCode;

public class Transaction {
    private SlotCode slotCode;
    private Product product;
    private Inventory inventory;
    private List<Coin> coins;
    public Transaction(Inventory inventory) {
        this.inventory = inventory;
        this.coins = new ArrayList<>();
    }

    public void setSlotCode(SlotCode slotCode) {
        this.slotCode = slotCode;

        this.product = this.inventory.getProduct(slotCode);
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
