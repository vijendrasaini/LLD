package design.couponengine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import design.couponengine.dto.EligibilityContext;
import design.couponengine.eligibility.MinEligibility;
import design.couponengine.eligibility.UserTypeEligibility;
import design.couponengine.enums.UserType;
import design.couponengine.model.Coupon;
import design.couponengine.service.CouponService;
import design.couponengine.strategy.discountcalculator.DiscountCalculator;
import design.couponengine.strategy.discountcalculator.FlatDiscountCalculator;

public class Main {
    public static void main(String[] args) {
        LocalDateTime expiresAt = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.now());

        DiscountCalculator discountCalculator = new FlatDiscountCalculator(100);
        Coupon coupon = new Coupon("FLAT100", "Gives flat 100 off.", expiresAt, discountCalculator);
        coupon.addEligibility(new MinEligibility(70));
        coupon.addEligibility(new UserTypeEligibility(UserType.VIP));

        // Flat coupons
        EligibilityContext eligibilityContext = new EligibilityContext();
        CouponService couponService = new CouponService();
        eligibilityContext.setAmount(110);
        eligibilityContext.setUserType(UserType.VIP);
        System.out.println(couponService.apply(coupon, eligibilityContext).getFinalAmount());


        // Percentage Coupons
        // discountCalculator = new PercentageDiscountCalculator(50);
        // Coupon percentageCoupon = new Coupon("FLAT10%", "Gives 10% off", expiresAt, discountCalculator);
        // percentageCoupon.addEligibility(new MinEligibility(200));

        // System.out.println(couponService.apply(percentageCoupon, eligibilityContext).getFinalAmount());
        // System.out.println(couponService.apply(percentageCoupon, eligibilityContext).getFinalAmount());
        // System.out.println(couponService.apply(percentageCoupon, eligibilityContext).getFinalAmount());
    }
}
