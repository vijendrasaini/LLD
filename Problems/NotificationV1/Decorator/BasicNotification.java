package Problems.NotificationV1.Decorator;

public class BasicNotification implements Notification {
    private String message;
    public BasicNotification(String message) {
        this.message = message;
    }

    @Override
    public String getContent() {
        return this.message;
    }
}
