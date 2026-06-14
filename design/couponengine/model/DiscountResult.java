package design.couponengine.model;

public class DiscountResult {
    private double originalAmount;
    private double discountAmount;
    public DiscountResult(double originalAmount, double discountAmount) {
        this.originalAmount = originalAmount;
        this.discountAmount = discountAmount;
    }

    public double getFinalAmount() {
        // System.out.println(originalAmount);
        // System.out.println(discountAmount);
        return originalAmount - discountAmount;
    }
}
