package Problems.NotificationV1.Observable;

import java.util.ArrayList;
import java.util.List;

import Problems.NotificationV1.Decorator.Notification;
import Problems.NotificationV1.Observer.Observer;

public class NotificationObservable implements Observable{
    private List<Observer> Observers;
    private Notification notification;
    public NotificationObservable() {
        this.Observers = new ArrayList<>();
    }

    @Override
    public void add(Observer observer) {
        this.Observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        this.Observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : Observers) {
            observer.update();
        }
    }

    public void update(Notification notification) {
        this.notification = notification;

        notifyObservers();
    }

    public Notification getNotification() {
        return this.notification;
    }
    
}
