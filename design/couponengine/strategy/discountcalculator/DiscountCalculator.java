package design.couponengine.strategy.discountcalculator;

import design.couponengine.dto.DiscountResult;

public interface DiscountCalculator {
    public DiscountResult calculate(double amount);
}
