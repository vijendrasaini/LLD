package Problems.NotificationV1.Strategy;

import Problems.NotificationV1.User;
import Problems.NotificationV1.Decorator.Notification;

public abstract class NotificationStrategy {
    protected User user;
    public NotificationStrategy(User user) {
        this.user = user;
    }

    abstract public void send(Notification notification);
}
