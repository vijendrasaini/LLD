package Problems.NotificationV1;


import Problems.NotificationV1.Decorator.Notification;
import Problems.NotificationV1.Observable.NotificationObservable;

public class NotificationService {
    private NotificationObservable observable;

    private static class Holder {
        static final NotificationService INSTANCE = new NotificationService();
    }

    public static NotificationService getInstance() {
        return Holder.INSTANCE;
    }

    public void setObservable(NotificationObservable observable) {
        this.observable = observable;
    }

    public void send(Notification notification) {
        this.observable.update(notification);
    }
}
