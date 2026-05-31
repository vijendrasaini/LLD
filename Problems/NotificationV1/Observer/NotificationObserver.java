package Problems.NotificationV1.Observer;

import java.util.ArrayList;
import java.util.List;

import Problems.NotificationV1.Decorator.Notification;
import Problems.NotificationV1.Observable.NotificationObservable;
import Problems.NotificationV1.Strategy.NotificationStrategy;

public class NotificationObserver implements Observer{
    private NotificationObservable notificationObservable;
    List<NotificationStrategy> list;
    public NotificationObserver(NotificationObservable notificationObservable) {
        this.notificationObservable = notificationObservable;
        this.list = new ArrayList<>();
    }

    @Override
    public void update() {
        Notification notification = this.notificationObservable.getNotification();
        for (NotificationStrategy notificationStrategy : list) {
            notificationStrategy.send(notification);
        }
    }

    public void addStrategy(NotificationStrategy notificationStrategy) {
        list.add(notificationStrategy);
    }

    public void removeStrategy(NotificationStrategy notificationStrategy) {
        list.remove(notificationStrategy);
    }
}
