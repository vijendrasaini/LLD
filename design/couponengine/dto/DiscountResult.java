package design.couponengine.dto;

public class DiscountResult {
    private double originalAmount;
    private double discountAmount;
    public DiscountResult(double originalAmount, double discountAmount) {
        this.originalAmount = originalAmount;
        this.discountAmount = discountAmount;
    }

    public double getFinalAmount() {
        return originalAmount - discountAmount;
    }
}
