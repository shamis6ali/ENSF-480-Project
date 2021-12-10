package Controller;


import Model.ImportData;
import Model.Property;

import java.util.List;

public class SearchController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);
    String type;
    String furnished;
    String quadrant;
    int bedrooms;
    int bathrooms;
    public SearchController(String type, String furnished, String quadrant, int bedrooms, int bathrooms) {
        this.type = type;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        search(type, furnished, quadrant, bedrooms, bathrooms);
    }

    //need to change return type and everything laterrr, also make adjustments for an "any" option
    public void search(String type, String furnished, String quadrant, int bedrooms, int bathrooms) {
        List<Property> properties = model.getProperties();
        //List results
        //bathrooms and bedrooms can not be <= 0, or empty

        for (int i = 0; i < properties.size(); i++) {
            if (type==properties.get(i).getApartmentType() && furnished==properties.get(i).getFurnished() && )
        //to be completeed, but if all matchs, add to results list
        }
    }

    public void registeredSearch() {
        //if subscribe = 1, then save this info in the searchCrit table!
    }
}
