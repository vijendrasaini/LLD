package design.couponengine.model;

import java.time.LocalDateTime;

import design.couponengine.strategy.discountcalculator.DiscountCalculator;

public class Coupon {
    private String code;
    private String description;
    private LocalDateTime expiresAt;
    private boolean isActive;

    private DiscountCalculator discountCalculator;
    public Coupon(String code, String description, LocalDateTime expiresAt, DiscountCalculator discountCalculator) {
        this.code = code;
        this.description = description;
        this.expiresAt = expiresAt;
        this.isActive = true;

        this.discountCalculator = discountCalculator;
    }

    public DiscountResult calculateDiscount(double amount) {
        return this.discountCalculator.calculate(amount);
    }

    public boolean isApplicable() {
        return expiresAt.isAfter(LocalDateTime.now()) && this.isActive;
    }
}
