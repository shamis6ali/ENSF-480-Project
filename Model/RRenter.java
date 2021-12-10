package Model;

public class RRenter implements SearchEnable, Observer {
    private String idrenter;
    private String name;
    private String password;
    private int subscribe;
    private String email;


    public RRenter(String idrenter, String name, String password, int subscribe, String email) {
        this.idrenter = idrenter;
        this.name = name;
        this.password = password;
        this.subscribe=subscribe;
        this.email=email;

    }

    public String getUsername() {
        return idrenter;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getSubscribe() {
        return subscribe;
    }

    public String getEmail() { return email; }

    @Override
    public void update() {

    }
}
