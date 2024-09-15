import java.util.ArrayList;
import java.util.List;

public class ObseverPattern {
    public static void main(String[] args) {
        Topic topic = new Topic();
        Observer observer1 = new TopicSubscriber("Subscriber1");
        Observer observer2 = new TopicSubscriber("Subscriber2");
        Observer observer3 = new TopicSubscriber("Subscriber3");

        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

        topic.publishMessage("new message");
    }
}

interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update();
}

class TopicSubscriber implements Observer {
    private String name;

    TopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("Observer " + name + " consumed latest message.");
    }
}

class Topic implements Subject {
    private List<Observer> observers;
    private String message;
    private boolean changed;

    Topic() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if(!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if(changed) {
            for(Observer observer: observers) {
                observer.update();
            }
            this.changed = false;
        }
    }

    public void publishMessage(final String message) {
        this.message = message;
        this.changed = true;
        notifyObservers();
    }
}
