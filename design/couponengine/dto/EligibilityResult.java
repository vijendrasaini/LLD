package design.couponengine.dto;

public class EligibilityResult {
    private boolean isPassed;
    private String reason;

    public EligibilityResult(boolean isPassed, String reason) {
        this.isPassed = isPassed;
        this.reason = reason;
    }

    public String getReason() {
        return this.reason;
    }

    public boolean isPassed() {
        return this.isPassed;
    }
}
