package Controller;


import Model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.*;

import static Controller.LoginController.USER;

public class SearchController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);
    String type;
    int furnished;
    int unfurnished;
    String furn;
    String unfurn;
    String quadrant;
    double bedrooms;
    double bathrooms;
    String beds;
    String baths;
    String searchID = "";
    List<Property> results;
    public SearchController(String type, int furnished, String quadrant, double bedrooms, double bathrooms) {
        this.type = type;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        if (furnished == 1)
            unfurnished = 0;
        else
            unfurnished = 1;
        furn = Integer.toString(furnished);
        unfurn = Integer.toString();
        beds = bedrooms.toString();
        baths = bathrooms.toString();
        search();
    }

    public List<Property> search() {
        if (bedrooms <= 0 || bathrooms <= 0 ) {
            return;
        }
        results = model.returnSearchResults(type, furnished, unfurnished, quadrant, bedrooms, bathrooms);
        return results;
    }

    public void registeredSearch() throws SQLException {
        //if subscribe = 1, then save this info in the searchCrit table!
        List<RRenter> rentList = model.getRegistRenters();
        List<SearchCriteria> savedSearches = model.getSearches();
        for (int i = 0; i < rentList.size(); i++) {
            if (USER.equals(rentList.get(i).getUsername()) && rentList.get(i).getSubscribe() == 1) {
                for (int j = 0; j < savedSearches.size(); j++) {
                    if (USER.equals(savedSearches.get(j).getIdRenter())) {
                        Update.searchRemove(dbsPath, dbsUser,dbsPass, USER);
                        System.out.println("old criteria deleted");
                        String added[] = {searchID, type, beds, baths, furn, unfurn, quadrant, USER};
                        Update.searchAdd(dbsPath, dbsUser,dbsPass, added);
                        System.out.println("criteria replaced");
                    } else {
                        String newadded[] = {searchID, type, beds, baths, furn, unfurn, quadrant, USER};
                        Update.searchAdd(dbsPath, dbsUser,dbsPass, newadded);
                        System.out.println("brand new criteria added");

                    }
                }
            }
            System.out.println("user not subscribed");

        }
    }

    public void subscribe() throws SQLException{
       Update.setSubscribeOn(dbsPath, dbsUser, dbsPath, USER);
        System.out.println("Subscribed!");

    }

    public void unsubscribe() throws  SQLException {
        Update.setSubscribeOff(dbsPath, dbsUser, dbsPath, USER);
        System.out.println("Unsubscribed!");

    }
}
