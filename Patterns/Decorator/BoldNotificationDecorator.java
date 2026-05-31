package Patterns.Decorator;

public class BoldNotificationDecorator implements Notification {
    private Notification notification;
    public BoldNotificationDecorator(Notification notification) {
        this.notification = notification;
    }

    @Override
    public String getContent() {
        return "<b>" + notification.getContent() + "</b>";
    }
}
