package design.couponengine.strategy.discountcalculator;

import design.couponengine.model.DiscountResult;

public interface DiscountCalculator {
    public DiscountResult calculate(double amount);
}
