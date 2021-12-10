package Model;

public interface Observer {
    public void update();
}

class ObserverUser implements Observer {
    Subject notification;
    Property desiredProperty;

    public ObserverUser() {
        super();
    }

    @Override
    public void update() {

    }
}


