package design.couponengine.service;

import java.util.List;

import design.couponengine.dto.DiscountResult;
import design.couponengine.dto.EligibilityResult;
import design.couponengine.model.Coupon;

public class CouponService {
    public DiscountResult apply(Coupon coupon, double amount) {
        DiscountResult discountResult = new DiscountResult(amount, 0);

        if(!coupon.isApplicable()) {
            return discountResult;
        }

        List<EligibilityResult> eligibilityResults = coupon.isEligible(amount);
        if(!eligibilityResults.isEmpty()) { // alteast one condition is failed.
            return discountResult;
        }
        
        return coupon.calculateDiscount(amount);
    }
}
