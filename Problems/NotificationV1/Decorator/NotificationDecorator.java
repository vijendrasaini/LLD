package Problems.NotificationV1.Decorator;

public abstract class NotificationDecorator implements Notification{

    private Notification notification;
    public NotificationDecorator(Notification notification) {
        this.notification = notification;
    }
}
