package Model;

public class Manager {
    private String idManager;
    private String name;
    private String username;
    private String password;

    public Manager(String idManager, String name, String username, String password) {
        this.idManager = idManager;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getIdManager() {
        return idManager;
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
}
