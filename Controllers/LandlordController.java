package Controllers;

import Model.*;

import java.util.ArrayList;
import java.util.List;

public class LandlordController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    public int changeStatus(String username, String id, String status) {
        int ret = 0; //if int = 0, invalid landlord
        List<Landlord> landlords = model.getLandlords();
        for (int i = 0; i < landlords.size(); i++) {
            if (username == landlords.get(i).getUsername()) {
                ret = 1; //if int = 1, invalid propertyID
            }
        }
        List<Property> properties = model.getProperties();
        for (int i = 0; i < properties.size(); i++) {
            // change getLandLordID to landlordUsername!!!!
            if(id == properties.get(i).getIdProperty() && username == properties.get(i).getLandlordId()) {
                //NEED SETSTATUSSS
                //property.get(i).setStatus(status);
            ret = 2; //if int = 2, status updated!
            }
        }
        return ret;
    }

}
