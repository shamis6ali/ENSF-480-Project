package Model;

public class Landlord {
    private String idLandlord;
    private String name;
    private String username;
    private String password;

    public Landlord(String idLandlord, String name, String username, String password) {
        this.idLandlord = idLandlord;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getIdLandlord() {
        return idLandlord;
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
