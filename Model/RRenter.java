package Model;

public class RRenter implements SearchEnable, Observer {
    private String idrenter;
    private String name;
    private String username;
    private String password;
    private int subscribe;

    public RRenter(String idrenter, String name, String username, String password,int subscribe) {
        this.idrenter = idrenter;
        this.name = name;
        this.username = username;
        this.password = password;
        this.subscribe=subscribe;

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

<<<<<<< HEAD
<<<<<<< HEAD

    public void update() {
    System.out.println("check");
    }


=======
    public int getSubscribe() {
        return subscribe;
    }
>>>>>>> main
=======
    public int getSubscribe() {
        return subscribe;
    }
>>>>>>> main
}
