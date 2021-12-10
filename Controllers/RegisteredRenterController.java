package Controller;

import Model.ImportData;
import Model.Update;


public class RegisteredRenterController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    public boolean subscribe (String username) {
        List<RegisteredRenter> rentList = model.getRegisteredRenters();
        boolean sub = false;
        for (int i = 0; i < rentList.size(); i++) {
            if (username == rentList.get(i).getUsername()) {
//I NEED A SET SUBSCRIPTION METHOD! rentList.set(i).setSubscribe(1);
                sub = true;
            }
            //if false is returned, view will show an invalid user error
            //we can also use email for this which may be better?
        }

        return sub;
    }

    public boolean unsubscribe (String username) {
        List<RegisteredRenter> rentList = model.getRegisteredRenters();
        boolean unsub = false;
        for (int i = 0; i < rentList.size(); i++) {
            if (username == rentList.get(i).getUsername()) {
//I NEED A SET SUBSCRIPTION METHOD! rentList.set(i).setSubscribe(0);
                unsub = true;
            }
            //if false is returned, view will show an invalid user error
            //we can also use email for this which may be better?
        }

        return unsub;
    }
}
