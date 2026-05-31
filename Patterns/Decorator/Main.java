package Patterns.Decorator;

public class Main {
    public static void main(String[] args) {

        // Italic + Bold + Normal text
        System.out.println(
                new ItalicNotificationDecorator(new BoldNotificationDecorator(new BasicNotification("I am Vijendra.")))
                        .getContent());

        // Bold + Italic + Normal text
        System.out.println(new BoldNotificationDecorator(new ItalicNotificationDecorator(new BasicNotification("Bold + Italic + Normal text"))).getContent());
    }
}
