package Model;

public class RRenter implements Observer {
    private String idrenter;
    private String name;
    private String username;
    private String password;

    public RRenter(String idrenter, String name, String username, String password) {
        this.idrenter = idrenter;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getIdrenter() {
        return idrenter;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void update() {

    }


}
