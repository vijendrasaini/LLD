package Patterns.Observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private List<Subscriber> observers;
    public Channel() {
        this.observers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        observers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        observers.remove(subscriber);
    }

    public void addVideo(String title) throws InterruptedException{
        System.out.println("Video is getting uploaded");
        Thread.sleep(2000);

        // Once video is uploaded notify to subsribers
        notifySubscribers("Here is the new Video! Please watch! : " + title);
    }

    public void notifySubscribers(String message) {
        for(Subscriber observer : observers) {
            observer.listen(message);
        }
    }
}
