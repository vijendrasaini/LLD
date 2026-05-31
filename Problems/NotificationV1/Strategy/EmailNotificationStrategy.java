package Problems.NotificationV1.Strategy;

import Problems.NotificationV1.User;
import Problems.NotificationV1.Decorator.Notification;

public class EmailNotificationStrategy extends NotificationStrategy {
    public EmailNotificationStrategy(User user) {
        super(user);
    }

    @Override
    public void send(Notification notification) {
        // Mimicing api behaviour by sleeping current thread for 1 sec
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("Error message : " + e.getMessage());
        }
        System.out.println("Sending Email Notification to user Email: %s, Content : %s".formatted(this.user.getEmail(), notification.getContent()));
    }
}
