package design.couponengine.eligibility;

import design.couponengine.dto.EligibilityContext;
import design.couponengine.dto.EligibilityResult;

public interface Eligibility {
    EligibilityResult check(EligibilityContext eligibilityContext);
}
