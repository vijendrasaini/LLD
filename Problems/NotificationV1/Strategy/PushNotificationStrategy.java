package Problems.NotificationV1.Strategy;

import javax.management.Notification;

import Problems.NotificationV1.User;

public class PushNotificationStrategy extends NotificationStrategy {
    public PushNotificationStrategy(User user) {
        super(user);
    }

    @Override
    public void send(Problems.NotificationV1.Decorator.Notification notification) {
        // Mimicing api behaviour by sleeping current thread for 1 sec
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error message : " + e.getMessage());
        }
        System.out.println("Sending Push Notification to user Push notificaton ID: %s, Content : %s".formatted(this.user.getPushNotificationId(), notification.getContent()));
    }
}
