package design.couponengine.strategy.discountcalculator;

import design.couponengine.model.DiscountResult;

public class FlatDiscountCalculator implements DiscountCalculator {
    private double flat;
    public FlatDiscountCalculator(double flat) {
        this.flat = flat;
    }

    @Override
    public DiscountResult calculate(double amount) {
        double discountAmount = flat;
        if(amount <= flat) {
            discountAmount = amount;
        }

        return new DiscountResult(amount, discountAmount);
    }
    
}
