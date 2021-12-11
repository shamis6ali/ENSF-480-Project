package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

    /**
     * The below variables are to make a connection with database
     */

    private Connecting connect;
    private String DBURL;
    private String USERNAME;
    private String PASSWORD;

    /**
     * Constructor for Update
     * @param url
     * @param username
     * @param password
     */

    private Update(String url,String username,String password){
        this.DBURL=url;
        this.USERNAME=username;
        this.PASSWORD=password;
        connect = new Connecting(DBURL,USERNAME,PASSWORD);
    }

    /**
     * This method adds landlords to the landlord table in the database
     * @param url
     * @param username
     * @param password
     * @param information
     * @throws SQLException
     */

    public static void landlordAdd(String url,String username,String password,String [] information) throws SQLException {
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO Landlord ("
                    + " idLandlord,"
                    + " Name,"
                    + " Password"
                    + " ) VALUES ("
                    + "?, ?, ?)";
            //System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setString(1,information[0]);
            myStmt.setString(2,information[1]);
            myStmt.setString(3,information[2]);
            //updt.connect.setResults(((java.sql.Statement) myStmt).executeUpdate(query));
            myStmt.executeUpdate();
            updt.connect.close();
        }catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            updt.connect.close();
            ex.printStackTrace();
        }

    }

    /**
     * This method removes landlords from the landlord table in the database
     * @param url
     * @param username
     * @param password
     * @param ID
     * @throws SQLException
     */


    public static void landlordRemove(String url, String username, String password, String  ID) throws SQLException{
    Update updt = new Update(url, username, password);
    try{

        String query = "DELETE FROM landlord WHERE idLandlord = ?";
           PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
           mystmt.setString(1, ID);
//
//            // update the arraylists and close connection
            mystmt.executeUpdate();
            updt.connect.close();


    }catch (SQLException e){
        updt.connect.close();
        e.printStackTrace();
    }

    }

    /**
     * It adds renter information in the database
     * @param url
     * @param username
     * @param password
     * @param information
     * @throws SQLException
     */

    public static void renterAdd(String url,String username,String password,String [] information) throws SQLException{
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO rrenter ("
                    + " idRenter,"
                    + " Name,"
                    + " Password,"
                    + "Subscribe,"
                    + "Email"
                    + " ) VALUES ("
                    + "?, ?, ?, 0, ?)";
            //System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setString(1,information[0]);
            myStmt.setString(2,information[1]);
            myStmt.setString(3,information[2]);
            myStmt.setString(4,information[3]);
            //updt.connect.setResults(((java.sql.Statement) myStmt).executeUpdate(query));
            myStmt.executeUpdate();
            updt.connect.close();
        }catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            updt.connect.close();
            ex.printStackTrace();
        }
    }

    /**
     * This method removes renters from the renters table in the database
     * @param url
     * @param username
     * @param password
     * @param ID
     * @throws SQLException
     */


    public static void renterRemove(String url, String username, String password, String  ID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{

            String query = "DELETE FROM rrenter WHERE idRenter = ?";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, ID);
//
//            // update the arraylists and close connection
            mystmt.executeUpdate();
            updt.connect.close();


        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }

    public static void propertyAdd(String url,String username,String password,String [] information) throws SQLException{
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO property ("
                    + " idProperty,"
                    + " Landlord_id,"
                    + " Apartment_type,"
                    + " No_of_bedrooms,"
                    + " No_of_bathrooms,"
                    + " Furnished,"
                    + " Unfurnished,"
                    + " City_quadrant,"
                    + " StatusP,"
                    + " Address"
                    + " ) VALUES ("
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setString(1,information[0]);
            myStmt.setString(2,information[1]);
            myStmt.setString(3,information[2]);
            myStmt.setDouble(4,Double.parseDouble(information[3]));
            myStmt.setDouble(5,Double.parseDouble(information[4]));
            myStmt.setInt(6,Integer.parseInt(information[5]));
            myStmt.setInt(7,Integer.parseInt(information[6]));
            myStmt.setString(8,information[7]);
            myStmt.setString(9,information[8]);
            myStmt.setString(10,information[9]);

            //updt.connect.setResults(((java.sql.Statement) myStmt).executeUpdate(query));
            myStmt.executeUpdate();
            updt.connect.close();
        }catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            updt.connect.close();
            ex.printStackTrace();
        }
    }

    public static void propertyRemove(String url, String username, String password, String  ID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{

            String query = "DELETE FROM property WHERE idProperty = ?";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, ID);
//
//            // update the arraylists and close connection
            mystmt.executeUpdate();
            updt.connect.close();


        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }

    public static void managerAdd(String url,String username,String password,String [] information) throws SQLException{
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO manager ("
                    + " idManager,"
                    + " Name,"
                    + " Username,"
                    + " Password,"
                    + " ) VALUES ("
                    + "?, ?, ?, ?)";
            //System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setString(1,information[0]);
            myStmt.setString(2,information[1]);
            myStmt.setString(3,information[2]);
            myStmt.setString(4,information[3]);
            //updt.connect.setResults(((java.sql.Statement) myStmt).executeUpdate(query));
            myStmt.executeUpdate();
            updt.connect.close();
        }catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            updt.connect.close();
            ex.printStackTrace();
        }
    }

    public static void managerRemove(String url, String username, String password, String  ID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{

            String query = "DELETE FROM manager WHERE idManager = ?";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, ID);
//
//            // update the arraylists and close connection
            mystmt.executeUpdate();
            updt.connect.close();


        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }

    public static void messageAdd(String url,String username,String password,String [] information){
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO messages ("
                    + " Property_id,"
                    + " Email,"
                    + " Message"
                    + " ) VALUES ("
                    + "?, ?, ? )";
            //System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setString(1,information[0]);
            myStmt.setString(2,information[1]);
            myStmt.setString(3,information[2]);
            //updt.connect.setResults(((java.sql.Statement) myStmt).executeUpdate(query));
            myStmt.executeUpdate();
            updt.connect.close();
        }catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            updt.connect.close();
            ex.printStackTrace();
        }
    }

    public static void messageRemove(String url, String username, String password,String propID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{

            String query = "DELETE FROM messages WHERE Property_id = ? ";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, propID);

            // update the arraylists and close connection
            mystmt.executeUpdate();
            updt.connect.close();


        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }
    public static void propertyAmountAdd(String url,String username,String password,double amount){
        Update updt = new Update(url,username,password);
        try{
            String query = "UPDATE Property_amount SET Amount= ?";
            //System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setDouble(1,amount);
            //updt.connect.setResults(((java.sql.Statement) myStmt).executeUpdate(query));
            myStmt.executeUpdate();
            updt.connect.close();
        }catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            updt.connect.close();
            ex.printStackTrace();
        }
    }

    public static void propertyPeriodAdd(String url,String username,String password,String period){
        Update updt = new Update(url,username,password);
        try{
            String query = "UPDATE Property_amount SET Period= ?";
            //System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setString(1,period);
            //updt.connect.setResults(((java.sql.Statement) myStmt).executeUpdate(query));
            myStmt.executeUpdate();
            updt.connect.close();
        }catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            updt.connect.close();
            ex.printStackTrace();
        }
    }

    public static void propertyAmountBoth(String url,String username,String password,String period,double amount){
        propertyAmountAdd(url,username,password,amount);
        propertyPeriodAdd(url,username,password,period);
    }


    public static void propertyAmountRemove(String url, String username, String password, String  propID,String lordID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{

            String query = "DELETE FROM property_amount WHERE Propertyid = ? AND Landlord_id = ? ";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, propID);
            mystmt.setString(2, lordID);
//
//            // update the arraylists and close connection
            mystmt.executeUpdate();
            updt.connect.close();


        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }

    public static void setStatus(String url,String username,String password,String idProperty,String status) throws SQLException{
        Update updt = new Update(url,username,password);
        try{
            String query = "UPDATE Property SET StatusP= ? WHERE idProperty= ?";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, status);
            mystmt.setString(2, idProperty);
            mystmt.executeUpdate();
            updt.connect.close();

        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }

    public static void searchAdd(String url,String username,String password,String [] information) throws SQLException{
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO search_criteria ("
                    + " idSearch,"
                    + " Apartment_type,"
                    + " No_of_bedrooms,"
                    + " No_of_bathrooms,"
                    + " Furnished,"
                    + " Unfurnished,"
                    + " City_quadrant,"
                    + " idRenter"
                    + " ) VALUES ("
                    + "?, ?, ?, ?, ?, ?, ?, ?)";
            //System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setString(1,information[0]);
            myStmt.setString(2,information[1]);
            myStmt.setDouble(3,Double.parseDouble(information[2]));
            myStmt.setDouble(4,Double.parseDouble(information[3]));
            myStmt.setInt(5,Integer.parseInt(information[4]));
            myStmt.setInt(6,Integer.parseInt(information[5]));
            myStmt.setString(7,information[6]);
            myStmt.setString(8,information[7]);

            //updt.connect.setResults(((java.sql.Statement) myStmt).executeUpdate(query));
            myStmt.executeUpdate();
            updt.connect.close();
        }catch (SQLException ex) {
            // if a sql exception occurs print stack of errors
            updt.connect.close();
            ex.printStackTrace();
        }
    }

    public static void setSubscribeOn(String url, String username, String password, String ID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{
            String query = "UPDATE RRenter SET Subscribe = 1 WHERE idRenter = ?";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, ID);
            mystmt.executeUpdate();
            updt.connect.close();

        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }

    public static void setSubscribeOff(String url, String username, String password, String ID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{
            String query = "UPDATE RRenter SET Subscribe = 0 WHERE idRenter = ?";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, ID);
            mystmt.executeUpdate();
            updt.connect.close();

        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }

    public static void searchRemove(String url, String username, String password, String ID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{

            String query = "DELETE FROM search_criteria WHERE Propertyid = ? ";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, ID);
//
//            // update the arraylists and close connection
            mystmt.executeUpdate();
            updt.connect.close();


        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }


}//end of class
