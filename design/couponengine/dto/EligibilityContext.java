package design.couponengine.dto;

import design.couponengine.enums.UserType;

public class EligibilityContext {
    private double amount;
    private UserType userType;

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public double getAmount() {
        return amount;
    }

    public UserType getUserType() {
        return userType;
    }

    public boolean isVIP() {
        return userType == UserType.VIP;
    }
}
