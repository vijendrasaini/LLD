package Problems.NotificationV1.Decorator;

public class ItalicNotificationDecorator implements Notification{
    private Notification notification;
    public ItalicNotificationDecorator(Notification notification) {
        this.notification = notification;
    }
    @Override
    public String getContent() {
        return "<italic>" + notification.getContent() + "</italic>";
    }
}
