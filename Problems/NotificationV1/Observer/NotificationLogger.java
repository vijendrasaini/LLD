package Problems.NotificationV1.Observer;


import Problems.NotificationV1.Decorator.Notification;
import Problems.NotificationV1.Observable.NotificationObservable;

public class NotificationLogger implements Observer{
    private NotificationObservable notificationObservable;
    public NotificationLogger(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
    }
    
    @Override
    public void update() {
        logNotification(this.notificationObservable.getNotification());
    }

    public void logNotification(Notification notification) {
        System.out.println("Logged Notification : %s".formatted(notification.getContent()));
    }
    
}
