package Problems.NotificationV1.Observable;

import Problems.NotificationV1.Observer.Observer;

public interface Observable {
    void add(Observer observer);
    void remove(Observer observer);
    void notifyObservers();
}
