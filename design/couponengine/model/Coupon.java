package design.couponengine.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import design.couponengine.dto.DiscountResult;
import design.couponengine.dto.EligibilityContext;
import design.couponengine.dto.EligibilityResult;
import design.couponengine.eligibility.Eligibility;
import design.couponengine.strategy.discountcalculator.DiscountCalculator;

public class Coupon {
    private int id;
    private String code;
    private String description;
    private LocalDateTime expiresAt;
    private boolean isActive;
    private static int counter = 0;
    private List<Eligibility> eligibilities;

    private DiscountCalculator discountCalculator;
    public Coupon(String code, String description, LocalDateTime expiresAt, DiscountCalculator discountCalculator) {
        this.id = ++counter; // just for a unique ID
        this.code = code;
        this.description = description;
        this.expiresAt = expiresAt;
        this.isActive = true;

        this.discountCalculator = discountCalculator;
        this.eligibilities = new ArrayList<>();
    }

    public DiscountResult calculateDiscount(double amount) {
        return this.discountCalculator.calculate(amount);
    }

    public boolean isApplicable() {
        return expiresAt.isAfter(LocalDateTime.now()) && this.isActive;
    }

    public int getId() {
        return id;
    }

    public void addEligibility(Eligibility eligibility) {
        this.eligibilities.add(eligibility);
    }

    public List<EligibilityResult> evaluateEligibility(EligibilityContext eligibilityContext) {
        return this.eligibilities.stream()
        .map(eligibility -> eligibility.check(eligibilityContext))
        .filter(eligibilityResult -> !eligibilityResult.isPassed())
        .toList();
    }
}
