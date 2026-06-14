package design.couponengine.eligibility;

import design.couponengine.dto.EligibilityContext;
import design.couponengine.dto.EligibilityResult;
import design.couponengine.enums.UserType;

public class UserTypeEligibility implements Eligibility{
    private UserType userType;
    public UserTypeEligibility(UserType userType) {
        this.userType = userType;
    }

    @Override
    public EligibilityResult check(EligibilityContext eligibilityContext) {
        if(eligibilityContext.getUserType() == this.userType) {
            return new EligibilityResult(true, null);
        }

        return new EligibilityResult(false, "User type is : %s".formatted(eligibilityContext.getUserType()));
    }
    
}
