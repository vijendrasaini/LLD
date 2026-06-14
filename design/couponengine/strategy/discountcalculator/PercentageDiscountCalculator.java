package design.couponengine.strategy.discountcalculator;

import design.couponengine.dto.DiscountResult;

public class PercentageDiscountCalculator implements DiscountCalculator {
    private double percentage;
    public PercentageDiscountCalculator(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public DiscountResult calculate(double amount) {
        double discountAmount = amount * percentage / 100; 
        return new DiscountResult(amount, discountAmount);
    }
}
