package Patterns.Decorator;

public abstract class NotificationDecorator implements Notification{

    private Notification notification;
    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }
}
