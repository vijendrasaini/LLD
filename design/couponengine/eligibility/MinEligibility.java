package design.couponengine.eligibility;

import design.couponengine.dto.EligibilityResult;

public class MinEligibility implements Eligibility {
    private double min;
    public MinEligibility(double min) {
        this.min = min;
    }

    @Override
    public EligibilityResult check(double amount) {
        if(amount < min) {
            return new EligibilityResult(false, "%f is less than required %f".formatted(amount, min));
        }

        return new EligibilityResult(true, null);
    }
}
