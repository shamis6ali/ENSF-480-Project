package Controller;

import Model.*;

import java.util.ArrayList;
import java.util.List;
public class ManagerController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath, dbsUser,dbsPass);

    int startD;
    int startM;
    int startY;
    int endD;
    int endM;
    int endY;

    public int getTotalHouses() {
        return totalHouses;
    }

    public int getRentedHouses() {
        return rentedHouses;
    }

    public int getActiveHouses() {
        return activeHouses;
    }

    public List<String> getrHouses() {
        return rHouses;
    }

    int totalHouses = 0;
    int rentedHouses = 0;
    int activeHouses = 0;
    List<String> rHouses;
    List<Property> properties = model.getProperties();


    public ManagerController() {
        retrieveProperties();
        retrieveLandlords();
        retrieveRenters();
    }

    public List<RRenter> retrieveRenters(){
        List<RRenter> renters = model.getRegistRenters();
        return renters;
    }
    public List<Landlord> retrieveLandlords(){
        List<Landlord> landlords = model.getLandlords();
        return landlords;
    }
    public List<Property> retrieveProperties(){
        List<Property> props = model.getProperties();
        return props;
    }

    private String getLandlordName(String id) {
        List<Landlord> list = retrieveLandlords();
        for (int i =0; i<list.size(); i++) {
            String check = list.get(i).getName();
            if (check.equals(id)) {
                return list.get(i).getName();
            }

        }
        return "";
    }

    public void getReport(int startD, int startM, int startY,
                          int endD, int endM, int endY) {
        this.startD = startD;
        this.startM = startM;
        this.startY = startY;
        this.endD = endD;
        this.endM = endM;
        this.endY = endY;
        for (int i = 0; i < properties.size(); i++ ) {
            if (properties.get(i).getDay() <= endD && properties.get(i).getMonth() <= endM &&
                    properties.get(i).getYear() <= endY && properties.get(i).getDay() >= startD &&
                    properties.get(i).getMonth() >= startM && properties.get(i).getYear() >= startY) {
                totalHouses++;
                if (properties.get(i).getStatus().equals("Rented")) {

                    if(!getLandlordName(properties.get(i).getLandlordId()).equals("")) {
                        rHouses.add(rentedHouses, getLandlordName(properties.get(i).getLandlordId()) + "," +
                                properties.get(i).getAddress() +
                                "," + properties.get(i).getIdProperty());
                        rentedHouses++;
                    }
                } else if (properties.get(i).getStatus().equals("Active")) {
                    activeHouses++;
                }
            }
        }
        getTotalHouses();
        getRentedHouses();
        getActiveHouses();
        getrHouses();

    }

//    public boolean changeStatus(String id, String status) {
//        List<Property> properties = model.getProperties();
//        for (int i = 0; i < properties.size(); i++) {
//            if(id == properties.get(i).getIdProperty()) {
//                //NEED SETSTATUSSS
//                //property.get(i).setStatus(status);
//                new ManagerController(); //to refresh fetched database results
//            }
//            else {
//                return false; //displays error: incorrect propID
//            }
//        }
//        return true;
//    }

}