package Model;

import java.util.*;

public interface Subject{
    public void subscribe(Observer o);
    public void unsubscribe(Observer o);
    public void notifyObservers();



}


class Notification implements Subject  {
    private List<Observer> observers;

    public void subscribe(Observer o){
    observers.add(o);
    }

    public Notification() {
        super();
    }

    @Override
    public void unsubscribe(Observer o) {
    observers.remove(o);
    }

    @Override
    public void notifyObservers() {

    }
}
