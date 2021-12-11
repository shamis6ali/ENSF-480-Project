package Model;
import java.sql.*;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
        updateLists();
        return landlords;
    }

    public List<RRenter> getRegistRenters()
    {   updateLists();
        return registRenters;
    }

    public List<Manager> getManagers() {

        updateLists();
        return managers;
    }

    public List<Property> getProperties() {
        updateLists();
        return properties;

    }

    public List<SearchCriteria> getSearches() {
        updateLists();
        return searches;
    }

    public List<Property_amount> getAmounts() {
        updateLists();
        return amounts;
    }

    public List<Messages> getMessages() {
        updateLists();
        return messages;
    }

    public Connecting getConnect() {
        return connect;
    }

    public void updateLists(){
        connect = new Connecting(DBURL, USERNAME, PASSWORD);
        fillArrays(connect);
        connect.close();
    }

    private void landlordFill(Connecting connection) {
        // try to make a connection and exclusively fill the Landlord list from
        // SQL File.sql
        try {
            // initialize arraylist
            this.landlords = new ArrayList<>();
            // get all the records from Landlord table
            Statement myStmt = connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Landlord";
            String[] landlordsS = new String[3];
            String[] columns = { "idLandlord", "Name", "Password" };

            connection.setResults(((Statement) myStmt).executeQuery(query));

            // after getting all the records from the SQL File.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    landlordsS[i] = connection.getResults().getString(columns[i]);
                }
                this.landlords.add(new Landlord(landlordsS[0], landlordsS[1], landlordsS[2]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void rentersFill(Connecting connection) {
        // try to make a connection and exclusively fill the RRenter list from
        // SQL File.sql
        try {
            // initialize arraylist
            this.registRenters = new ArrayList<>();
            // get all the records from RRenter table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "RRenter";
            String[] registRenterS = new String[5];
            String[] columns = { "idRenter", "Name", "Password","Subscribe","Email" };

            connection.setResults(((Statement) myStmt).executeQuery(query));

            // after getting all the records from the SQL File.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    registRenterS[i] = connection.getResults().getString(columns[i]);
                }
                this.registRenters.add(new RRenter(registRenterS[0],registRenterS[1],
                        registRenterS[2],Integer.parseInt(registRenterS[3]),registRenterS[4]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void managersFill(Connecting connection) {
        // try to make a connection and exclusively fill the Manager list from
        // SQL File.sql
        try {
            // initialize arraylist
            this.managers = new ArrayList<>();
            // get all the records from Manager table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Manager";
            String[] managerS = new String[4];
            String[] columns = { "idManager", "Name", "Username", "Password" };

            connection.setResults(((Statement) myStmt).executeQuery(query));

            // after getting all the records from the SQL File.sql database store in array
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
        // try to make a connection and exclusively fill the Property list from
        // SQL File.sql
        try {
            // initialize arraylist
            this.properties = new ArrayList<>();
            // get all the records from Property table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Property";
            String[] propertyS = new String[13];
            String[] columns = { "idProperty", "Landlord_id", "Apartment_type", "No_of_bedrooms","No_of_bathrooms",
                    "Furnished","Unfurnished","City_quadrant","StatusP","Address","Day","Month","Year" };

            connection.setResults(((Statement) myStmt).executeQuery(query));

            // after getting all the records from the SQL File.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    propertyS[i] = connection.getResults().getString(columns[i]);
                }
                this.properties.add(new Property(propertyS[0],propertyS[1],propertyS[2],Double.parseDouble(propertyS[3]),Double.parseDouble(propertyS[4]),
                        Integer.parseInt(propertyS[5]),Integer.parseInt(propertyS[6]),propertyS[7],propertyS[8],propertyS[9],
                        Integer.parseInt(propertyS[10]),
                        Integer.parseInt(propertyS[11]),Integer.parseInt(propertyS[12])));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void searchFill(Connecting connection) {
        // try to make a connection and exclusively fill the Search_Criteria list from
        // SQL File.sql
        try {
            // initialize arraylist
            this.searches = new ArrayList<>();
            // get all the records from manufacturer table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Search_Criteria";
            String[] searchS = new String[8];
            String[] columns = { "idSearch", "Apartment_type", "No_of_bedrooms","No_of_bathrooms","Furnished","Unfurnished","City_quadrant","idRenter" };

            connection.setResults(((Statement) myStmt).executeQuery(query));

            // after getting all the records from the SQL File.sql database store in array
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
        // try to make a connection and exclusively fill the Property_amount list from
        // SQL File.sql
        try {
            // initialize arraylist
            this.amounts = new ArrayList<>();
            // get all the records from Property_amount table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Property_amount";
            String[] amountS = new String[2];
            String[] columns = {"Amount","Period"};

            connection.setResults(((Statement) myStmt).executeQuery(query));

            // after getting all the records from the SQL File.sql database store in array
            // list
            while (connection.getResults().next()) {
                for (int i = 0; i < columns.length; i++) {
                    amountS[i] = connection.getResults().getString(columns[i]);
                }
                this.amounts.add(new Property_amount(Double.parseDouble(amountS[0]),amountS[1]));
            }
        } catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            ex.printStackTrace();
        }
    }

    private void messagesFill(Connecting connection) {
        // try to make a connection and exclusively fill the Messages list from
        // SQL File.sql
        try {
            // initialize arraylist
            this.messages = new ArrayList<>();
            // get all the records from Messages table
            Statement myStmt = (Statement) connection.getDbConnect().createStatement();
            String query = "SELECT * FROM " + "Messages";
            String[] messageS = new String[3];
            String[] columns = { "Property_id", "Email", "Message"};

            connection.setResults(((Statement) myStmt).executeQuery(query));

            // after getting all the records from the SQL File.sql database store in array
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
        // upon call fills all the arraylists, one for each table in SQL File.sql
        // database
        this.landlordFill(connection);
        this.managersFill(connection);
        this.rentersFill(connection);
        this.propertyFill(connection);
        this.searchFill(connection);
    }

//    public void removeEntity( String table,String foreignKeyName, String ID){
//
//
//
//        Connecting newConnect = new Connecting(this.DBURL, this.USERNAME, this.PASSWORD);
//        // try to delete specific records from a specified table
//        try {
//            String query = "DELETE FROM " + table + " WHERE " + foreignKeyName + " = ?";
//            PreparedStatement mystmt = newConnect.getDbConnect().prepareStatement(query);
//            mystmt.setString(1, ID);
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

    //public void addProperty(String










}
