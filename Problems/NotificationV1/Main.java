package Problems.NotificationV1;

import Problems.NotificationV1.Decorator.BasicNotification;
import Problems.NotificationV1.Decorator.BoldNotificationDecorator;
import Problems.NotificationV1.Decorator.ItalicNotificationDecorator;
import Problems.NotificationV1.Decorator.Notification;
import Problems.NotificationV1.Observable.NotificationObservable;
import Problems.NotificationV1.Observer.NotificationLogger;
import Problems.NotificationV1.Observer.NotificationObserver;
import Problems.NotificationV1.Strategy.EmailNotificationStrategy;
import Problems.NotificationV1.Strategy.NotificationStrategy;
import Problems.NotificationV1.Strategy.PushNotificationStrategy;
import Problems.NotificationV1.Strategy.SMSNotificationStrategy;

public class Main {
    public static void main(String[] args) {
        User user = new User("Vijendra", "vijendra@gmail.com", "+91-9358222315");
        user.setPushNotificationId("9svda9sje9a8s3asdvas98eu");

        NotificationStrategy emailNotificationStrategy = new EmailNotificationStrategy(user);
        NotificationStrategy smsNotificationStrategy = new SMSNotificationStrategy(user);
        NotificationStrategy pushNotificationStrategy = new PushNotificationStrategy(user);

        NotificationObservable notificationObservable = new NotificationObservable();
        
        NotificationLogger notificationLogger = new NotificationLogger(notificationObservable);
        NotificationObserver notificationObserver = new NotificationObserver(notificationObservable);
        notificationObserver.addStrategy(emailNotificationStrategy);
        notificationObserver.addStrategy(smsNotificationStrategy);
        notificationObserver.addStrategy(pushNotificationStrategy);
        
        notificationObservable.add(notificationObserver);
        notificationObservable.add(notificationLogger);

        NotificationService notificationService = NotificationService.getInstance();
        notificationService.setObservable(notificationObservable);
        
        notificationService.send(new BoldNotificationDecorator(new ItalicNotificationDecorator(new BasicNotification("Hello there!"))));
    }
}
