package design.couponengine.eligibility;

import design.couponengine.dto.EligibilityContext;
import design.couponengine.dto.EligibilityResult;

public class MinEligibility implements Eligibility {
    private double min;
    public MinEligibility(double min) {
        this.min = min;
    }

    @Override
    public EligibilityResult check(EligibilityContext eligibilityContext) {
        if(eligibilityContext.getAmount() < min) {
            return new EligibilityResult(false, "%f is less than required %f".formatted(eligibilityContext.getAmount(), min));
        }

        return new EligibilityResult(true, null);
    }
}
