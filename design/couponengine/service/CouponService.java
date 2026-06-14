package design.couponengine.service;

import java.time.LocalDateTime;

import design.couponengine.model.Coupon;
import design.couponengine.model.DiscountResult;

public class CouponService {
    public double apply(Coupon coupon, double amount) {
        double finalAmount = amount;
        if(coupon.getExpiresAt().isBefore(LocalDateTime.now())) {
            return finalAmount;
        }

        if(!coupon.isActive()) {
            return finalAmount;
        }

        DiscountResult discountResult = coupon.apply(amount);
        return discountResult.getFinalAmount();
    }
}
