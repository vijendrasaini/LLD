package design.couponengine;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import design.couponengine.model.Coupon;
import design.couponengine.strategy.discountcalculator.DiscountCalculator;
import design.couponengine.strategy.discountcalculator.FlatDiscountCalculator;
import design.couponengine.strategy.discountcalculator.PercentageDiscountCalculator;

public class Main {
    public static void main(String[] args) {
        LocalDateTime expiresAt = LocalDateTime.of(LocalDate.now().plusDays(1), LocalTime.now());
        DiscountCalculator discountCalculator = new FlatDiscountCalculator(100);
        Coupon coupon = new Coupon("FLAT100", "Gives flat 100 off.", expiresAt, discountCalculator);

        // Flat coupons
        // System.out.println(coupon.apply(200).getFinalAmount()); // need to pay now only 100
        // System.out.println(coupon.apply(100).getFinalAmount()); // no need to paything
        // System.out.println(coupon.apply(10).getFinalAmount()); // No need to pay anything

        // Percentage Coupons
        discountCalculator = new PercentageDiscountCalculator(10);
        Coupon percentageCoupon = new Coupon("FLAT10%", "Gives 10% off", expiresAt, discountCalculator);
        System.out.println(percentageCoupon.apply(100).getFinalAmount());
        System.out.println(percentageCoupon.apply(5).getFinalAmount());
        System.out.println(percentageCoupon.apply(10).getFinalAmount());
    }
}
