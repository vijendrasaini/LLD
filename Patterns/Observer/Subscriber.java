package Patterns.Observer;

public class Subscriber implements Listener {
    private String name;
    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void listen(String message) {
        // send notification to subscription that Some Post or Video has been added.
        System.out.println("Hey %s! Update from channel : %s".formatted(this.name, message));
    }

}