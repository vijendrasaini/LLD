package design.couponengine.eligibility;

import design.couponengine.dto.EligibilityResult;

public interface Eligibility {
    EligibilityResult check(double amount);
}
