package design.couponengine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import design.couponengine.eligibility.MinEligibility;
import design.couponengine.model.Coupon;
import design.couponengine.service.CouponService;
import design.couponengine.strategy.discountcalculator.DiscountCalculator;
import design.couponengine.strategy.discountcalculator.FlatDiscountCalculator;
import design.couponengine.strategy.discountcalculator.PercentageDiscountCalculator;

public class Main {
    public static void main(String[] args) {
        LocalDateTime expiresAt = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.now());

        DiscountCalculator discountCalculator = new FlatDiscountCalculator(100);
        Coupon coupon = new Coupon("FLAT100", "Gives flat 100 off.", expiresAt, discountCalculator);
        coupon.addEligibility(new MinEligibility(70));

        // Flat coupons
        CouponService couponService = new CouponService();
        System.out.println(couponService.apply(coupon, 200).getFinalAmount());
        System.out.println(couponService.apply(coupon, 100).getFinalAmount());
        System.out.println(couponService.apply(coupon, 10).getFinalAmount());
        System.out.println("___________________");


        // Percentage Coupons
        discountCalculator = new PercentageDiscountCalculator(50);
        Coupon percentageCoupon = new Coupon("FLAT10%", "Gives 10% off", expiresAt, discountCalculator);
        percentageCoupon.addEligibility(new MinEligibility(200));

        System.out.println(couponService.apply(percentageCoupon, 200).getFinalAmount());
        System.out.println(couponService.apply(percentageCoupon, 100).getFinalAmount());
        System.out.println(couponService.apply(percentageCoupon, 10).getFinalAmount());
    }
}
