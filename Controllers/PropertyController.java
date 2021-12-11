package Controller;

import Model.ImportData;
import Model.*;

import java.sql.SQLException;
import java.util.List;

import static Controller.LoginController.USER;

public class PropertyController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    String propID, type, beds, baths, furn, unfurn, quad, address;
    int furnished, unfurnished;
    double bathrooms, bedrooms;
    public PropertyController() {}
    public PropertyController(String propID, String type, double bathrooms, double bedrooms, int furnished,
                              String quad, String address) {
        this.propID = propID;
        this.type = type;
        this.bedrooms= bedrooms;
        this.bathrooms = bathrooms;
        if (furnished == 1)
            unfurnished = 0;
        else
            unfurnished = 1;
        furn = Integer.toString(furnished);
        unfurn = Integer.toString(unfurnished);
        beds = Double.toString(bedrooms);
        baths = Double.toString(bathrooms);
    }

    public void list() throws SQLException {
        List<Property> properties = model.getProperties();
        for (int i = 0; i < properties.size(); i++) {
            if (propID.equals(properties.get(i).getIdProperty())) {
                System.out.println("a property with this ID already exists");
                break;
            }
        }
        String[] listing = {propID, USER, type, beds, baths, furn, unfurn, quad, "inactive", address};
        Update.propertyAdd(dbsPath, dbsUser,dbsPass, listing);
    }

    


}