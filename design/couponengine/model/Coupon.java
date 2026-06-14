package design.couponengine.model;

import java.time.LocalDateTime;

import design.couponengine.strategy.discountcalculator.DiscountCalculator;

public class Coupon {
    private String id;
    private String description;
    private LocalDateTime expiresAt;
    private boolean isActive;

    private DiscountCalculator discountCalculator;
    public Coupon(String id, String description, LocalDateTime expiresAt, DiscountCalculator discountCalculator) {
        this.id = id;
        this.description = description;
        this.expiresAt = expiresAt;
        this.isActive = true;

        this.discountCalculator = discountCalculator;
    }

    public DiscountResult apply(int amount) {
        return this.discountCalculator.calculate(amount);
    }
}
