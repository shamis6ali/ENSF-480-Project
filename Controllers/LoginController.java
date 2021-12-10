package Controller;

import Model.*;

import java.util.List;

public class LoginController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";

    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    public List<RRenter> rentList = model.getRegistRenters();
    public List<Landlord> landList = model.getLandlords();

    public boolean rLogin(String username, String password) { //might not even need to be static
        boolean valid = false;
        for (int i = 0; i < rentList.size(); i++) {
            if (username == rentList.get(i).getUsername() && password == rentList.get(i).getPassword())
                valid = true;
        }
        if (valid) {
            System.out.println("valid renter");
        } else {
            System.out.println("invalid renter");
        }
        return valid;
    }

    public boolean mLogin(String username, String password) {
        List<Manager> mgrList = model.getManagers();
        boolean valid = false;
        for (int i = 0; i < mgrList.size(); i++) {
            if (username == mgrList.get(i).getUsername() && password == mgrList.get(i).getPassword())
                valid = true;
        }
        if (valid) {
            System.out.println("valid manager");
        } else {
            System.out.println("invalid manager");
        }
        return valid;
    }

    public boolean lLogin(String username, String password) {
        List<Landlord> landList = model.getLandlords();
        boolean valid = false;
        for (int i = 0; i < landList.size(); i++) {
            if (username == landList.get(i).getUsername() && password == landList.get(i).getPassword())
                valid = true;
        }
        if (valid) {
            System.out.println("valid landlord");
        } else {
            System.out.println("invalid landlord");
        }
        return valid;
    }

    public boolean rRegister(String name, String username, String password) {
        boolean reg = true;
        for (int i = 0; i < rentList.size(); i++) {
            if (username == rentList.get(i).getUsername()) {
                reg = false;
                System.out.println("username already exists");
                return reg;
            }
        }
        String renter[] = {name, username, password};
        Update.renterAdd("jdbc:mysql://127.0.0.1:3306/Property_Rental", "root", "Hiba0105!", renter);
        System.out.println("registered!");
        return reg;
    }

    public boolean lRegister(String name, String username, String password) {
        boolean reg = true;
        for (int i = 0; i < landList.size(); i++) {
            if (username == landList.get(i).getUsername()) {
                reg = false;
                System.out.println("username already exists");
                return reg;
            }
        }
        String landlord[] = {name, username, password};
        Update.renterAdd("jdbc:mysql://127.0.0.1:3306/Property_Rental", "root", "Hiba0105!", landlord);
        System.out.println("registered!");
        return reg;
    }
    

}