package Model;

import java.util.ArrayList;

public interface Subject{
    public void subscribe(Observer o);
    public void unsubscribe(Observer o);
    public void notifyO();



}


class Notification implements Subject  {
    private ArrayList<Observer> observers;
    public void subscribe(Observer o){

    }

    public Notification() {
        super();
    }

    @Override
    public void unsubscribe(Observer o) {

    }

    @Override
    public void notifyO() {

    }
}
