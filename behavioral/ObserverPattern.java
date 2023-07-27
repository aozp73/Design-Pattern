package behavioral;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Observer " + name + " received message: " + message);
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer observer1 = new ConcreteObserver("One");
        Observer observer2 = new ConcreteObserver("Two");
        Observer observer3 = new ConcreteObserver("Three");

        subject.attach(observer1);
        subject.attach(observer2);
        subject.attach(observer3);

        subject.setState("Hello, Observers!");
    }
}
