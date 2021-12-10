package Controller;

import Model.ImportData;
import Model.Update;

import java.util.List;

public class LoginController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";

    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    public boolean rLogin(String username, String password) { //might not even need to be static
        List<RegisteredRenter> rentList = model.getRegisteredRenters();
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

    public void rRegister(String id, String name, String username, String password, String email) {
        //remove id's of users, username alone should be fine and unique, and email for notifications
        String renter[] = {id, name, username, password};
        Update.renterAdd("jdbc:mysql://127.0.0.1:3306/Property_Rental", "root", "Hiba0105!", renter)
    }

//    public void rRegister(String name, String username, String password, String email) {
//        //remove id's of users, username alone should be fine and unique, and email for notifications
//        String renter[] = {name, email, username, password};
//        Update.renterAdd("jdbc:mysql://127.0.0.1:3306/Property_Rental", "root", "Hiba0105!", renter);//ensure subsribed =0
//    }

    public void lRegister(String id, String name, String username, String password) {
        //remove id's of users, username alone should be fine and unique, and email for notifications
        String landlord[] = {id, name, username, password};
        Update.renterAdd("jdbc:mysql://127.0.0.1:3306/Property_Rental", "root", "Hiba0105!", landlord);
    }

    //preferred:
//    public void lRegister(String name, String username, String password) {
//        //remove id's of users, username alone should be fine and unique, and email for notifications
//        String landlord[] = {name, username, password};
//        Update.renterAdd("jdbc:mysql://127.0.0.1:3306/Property_Rental", "root", "Hiba0105!", landlord);
//    }



}