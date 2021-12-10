package Model;

public class Landlord {
    private String idLandlord;
    private String name;
    private String password;

    public Landlord(String idLandlord, String name, String password) {
        this.idLandlord = idLandlord;
        this.name = name;
        this.password = password;
    }

    public String getUsername() {
        return idLandlord;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
