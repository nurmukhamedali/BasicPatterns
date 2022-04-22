package observer.labaratory;
import java.util.*;
enum State{
    On, Off
}
interface Observer {
    void update(State state);
}

abstract class Subject {
    private State state;
    public Subject(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    public abstract void attach(Observer observer);
    public abstract void detach(Observer observer);
    public abstract void notifyObservers();
}
class ConcreteObserver implements Observer {
    private Subject subject;
    private State observerState;
    private String name;

    public ConcreteObserver(String name, Subject subject) {
        this.name = name;
        this.subject = subject;
        this.observerState = subject.getState();
    }

    @Override
    public void update(State state) {
        this.observerState = state;
        System.out.println("Hey, " + name + "! The State has been changed to: " + state);
    }
}
class ConcreteSubject extends Subject {
    private List<Observer> concreteObservers = new ArrayList<>();

    public ConcreteSubject(State state) {
        super(state);
    }

    @Override
    public void attach(Observer observer) {
        this.concreteObservers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        this.concreteObservers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: concreteObservers) {
            observer.update(super.getState());
        }
    }
}

class Main{
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject(State.On);
        Observer observer1 = new ConcreteObserver("John", subject);
        Observer observer2 = new ConcreteObserver("Hannah Montana", subject);
        subject.attach(observer1);
        subject.attach(observer2);
        subject.setState(State.Off);
        subject.notifyObservers();
    }
}
