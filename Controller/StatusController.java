package Controller;

import Model.Landlord;

import java.sql.SQLException;
import java.util.List;
import Model.*;

import static Controller.LoginController.USER;

public class StatusController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    public String status;
    public String propID;
    public StatusController(String propID, String status) {
        this.status = status;
        this.propID = propID;
    }


    public void landlordStatus() throws SQLException {
        List<Property> properties= model.getProperties();
        for (int i = 0; i < properties.size(); i++) {
            if (USER.equals(properties.get(i).getLandlordId()) && propID.equals(properties.get(i).getIdProperty())) {
               if (status.equals("rented") || status.equals("cancelled") || status.equals("suspended")) {
                   Update.setStatus(dbsPath, dbsUser,dbsPass, propID, status)
               }
            }

        }
    }

    public void managerStatus() throws SQLException {
        List<Property> properties= model.getProperties();
        for (int i = 0; i < properties.size(); i++) {
                if (status.equals("rented") || status.equals("cancelled") || status.equals("suspended") ||
                        status.equals("active")) {
                    Update.setStatus(dbsPath, dbsUser, dbsPass, propID, status)
                }
            }

        }
    }