package design.couponengine.service;

import java.util.List;

import design.couponengine.dto.DiscountResult;
import design.couponengine.dto.EligibilityContext;
import design.couponengine.dto.EligibilityResult;
import design.couponengine.model.Coupon;

public class CouponService {
    public DiscountResult apply(Coupon coupon, EligibilityContext eligibilityContext) {
        DiscountResult discountResult = new DiscountResult(eligibilityContext.getAmount(), 0);

        if(!coupon.isApplicable()) {
            return discountResult;
        }

        List<EligibilityResult> eligibilityResults = coupon.evaluateEligibility(eligibilityContext);
        if(!eligibilityResults.isEmpty()) { // alteast one condition is failed.
            // These result could be saved repository for history
            return discountResult;
        }
        
        return coupon.calculateDiscount(eligibilityContext.getAmount());
    }
}
