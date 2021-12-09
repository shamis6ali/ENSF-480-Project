package Model;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImportData {
    private List<Landlord> landlords;
    private List<RRenter> registRenters;
    private List<Manager> managers;
    private List<Property> properties;
    private List<SearchCriteria> searches;
    private List<Property_amount> amounts;
    private List<Messages> messages;
    private Connecting connect;
    private final String DBURL, USERNAME, PASSWORD;

    public ImportData(String DBURL, String USERNAME, String PASSWORD) {
        this.DBURL = DBURL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;

        connect = new Connecting(DBURL, USERNAME, PASSWORD);
        fillArrays(connect);
        connect.close();
    }

    public List<Landlord> getLandlords() {
        return landlords;
    }

    public List<RRenter> getRegistRenters() {
        return registRenters;
    }

    public List<Manager> getManagers() {
        return managers;
    }

    public List<Property> getProperties() {
        return properties;

    }

    public List<SearchCriteria> getSearches() {
        return searches;
    }

    public List<Property_amount> getAmounts() {
        return amounts;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public Connecting getConnect() {
        return connect;
    }

    private void landlordFill(Connecting connection) {
        // try to make a connection and exclusively fill the manufacturer list from
        // inventory.sql
        try {
            // initialize arraylist
            this.landlords = new ArrayList<>();
            // get all the records from manufacturer table
            Statement myStmt = connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Landlord";
            String[] landlordsS = new String[4];
            String[] columns = { "idLandlord", "Name", "Username", "Password" };

            connection.setResults(((java.sql.Statement) myStmt).executeQuery(query));

            // after getting all the records from the inventory.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    landlordsS[i] = connection.getResults().getString(columns[i]);
                }
                this.landlords.add(new Landlord(landlordsS[0], landlordsS[1], landlordsS[2], landlordsS[3]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void rentersFill(Connecting connection) {
        // try to make a connection and exclusively fill the manufacturer list from
        // inventory.sql
        try {
            // initialize arraylist
            this.registRenters = new ArrayList<>();
            // get all the records from manufacturer table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "RRenter";
            String[] registRenterS = new String[4];
            String[] columns = { "idRenter", "Name", "Username", "Password" };

            connection.setResults(((java.sql.Statement) myStmt).executeQuery(query));

            // after getting all the records from the inventory.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    registRenterS[i] = connection.getResults().getString(columns[i]);
                }
                this.registRenters.add(new RRenter(registRenterS[0],registRenterS[1],registRenterS[2], registRenterS[3]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void managersFill(Connecting connection) {
        // try to make a connection and exclusively fill the manufacturer list from
        // inventory.sql
        try {
            // initialize arraylist
            this.managers = new ArrayList<>();
            // get all the records from manufacturer table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Manager";
            String[] managerS = new String[4];
            String[] columns = { "idManager", "Name", "Username", "Password" };

            connection.setResults(((java.sql.Statement) myStmt).executeQuery(query));

            // after getting all the records from the inventory.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    managerS[i] = connection.getResults().getString(columns[i]);
                }
                this.managers.add(new Manager(managerS[0],managerS[1],managerS[2],managerS[3]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void propertyFill(Connecting connection) {
        // try to make a connection and exclusively fill the manufacturer list from
        // inventory.sql
        try {
            // initialize arraylist
            this.properties = new ArrayList<>();
            // get all the records from manufacturer table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Property";
            String[] propertyS = new String[10];
            String[] columns = { "idProperty", "Landlord_id", "Apartment_type", "No_of_bedrooms","No_of_bathrooms","Furnished","Unfurnished","City_quadrant","Status","Address" };

            connection.setResults(((java.sql.Statement) myStmt).executeQuery(query));

            // after getting all the records from the inventory.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    propertyS[i] = connection.getResults().getString(columns[i]);
                }
                this.properties.add(new Property(propertyS[0],propertyS[1],propertyS[2],Double.parseDouble(propertyS[3]),Double.parseDouble(propertyS[4]),
                        Integer.parseInt(propertyS[5]),Integer.parseInt(propertyS[6]),propertyS[7],propertyS[8],propertyS[9]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void searchFill(Connecting connection) {
        // try to make a connection and exclusively fill the manufacturer list from
        // inventory.sql
        try {
            // initialize arraylist
            this.searches = new ArrayList<>();
            // get all the records from manufacturer table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Search_Criteria";
            String[] searchS = new String[8];
            String[] columns = { "idSearch", "Apartment_type", "No_of_bedrooms","No_of_bathrooms","Furnished","Unfurnished","City_quadrant","idRenter" };

            connection.setResults(((java.sql.Statement) myStmt).executeQuery(query));

            // after getting all the records from the inventory.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    searchS[i] = connection.getResults().getString(columns[i]);
                }
                this.searches.add(new SearchCriteria(searchS[0],searchS[1],Double.parseDouble(searchS[2]),Double.parseDouble(searchS[3]),
                        Integer.parseInt(searchS[4]),Integer.parseInt(searchS[5]),searchS[6],searchS[7]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void amountFill(Connecting connection) {
        // try to make a connection and exclusively fill the manufacturer list from
        // inventory.sql
        try {
            // initialize arraylist
            this.amounts = new ArrayList<>();
            // get all the records from manufacturer table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Property_amount";
            String[] amountS = new String[4];
            String[] columns = { "Propertyid", "Landlord_id", "Amount","Period"};

            connection.setResults(((java.sql.Statement) myStmt).executeQuery(query));

            // after getting all the records from the inventory.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    amountS[i] = connection.getResults().getString(columns[i]);
                }
                this.amounts.add(new Property_amount(amountS[0],amountS[1],Double.parseDouble(amountS[2]),amountS[3]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void messagesFill(Connecting connection) {
        // try to make a connection and exclusively fill the manufacturer list from
        // inventory.sql
        try {
            // initialize arraylist
            this.messages = new ArrayList<>();
            // get all the records from manufacturer table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Messages";
            String[] messageS = new String[3];
            String[] columns = { "Landlord_id", "Renter_id", "Message"};

            connection.setResults(((java.sql.Statement) myStmt).executeQuery(query));

            // after getting all the records from the inventory.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    messageS[i] = connection.getResults().getString(columns[i]);
                }
                this.messages.add(new Messages(messageS[0],messageS[1],messageS[2]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    //TODO the method is not correctly implemented


//    public void update(String table, String id) {
//        // make sure table being modified is not manufacturer table
//        // make a connection to inventory.sql database from database info
//        Connecting newConnect = new Connecting(this.DBURL, this.USERNAME, this.PASSWORD);
//        // try to delete specific records from a specified table
//        try {
//            String query = "DELETE FROM " + table + " WHERE " + "ID = ?";
//            PreparedStatement mystmt = newConnect.getDbConnect().prepareStatement(query);
//            mystmt.setString(1, id);
//
//            // update the arraylists and close connection
//            mystmt.executeUpdate();
//            fillArrays(newConnect);
//            newConnect.close();
//
//        } catch (SQLException ex) {
//            // if a sql exception occurs print stack of errors
//            ex.printStackTrace();
//        }
//    }


    public void fillArrays(Connecting connection) {
        // upon call fills all the arraylists, one for each table in inventory.sql
        // database
        this.landlordFill(connection);
        this.managersFill(connection);
        this.rentersFill(connection);
        this.propertyFill(connection);
        this.searchFill(connection);
    }





}
