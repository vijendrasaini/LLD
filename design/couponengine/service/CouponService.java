package design.couponengine.service;

import design.couponengine.model.Coupon;
import design.couponengine.model.DiscountResult;

public class CouponService {
    public DiscountResult apply(Coupon coupon, double amount) {
        DiscountResult discountResult = new DiscountResult(amount, 0);
        if(coupon.isApplicable()) {
            return coupon.calculateDiscount(amount);
        }

        return discountResult;
    }
}
