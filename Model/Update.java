package Model;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
    private Connecting connect;
    private String DBURL;
    private String USERNAME;
    private String PASSWORD;

    private Update(String url,String username,String password){
        this.DBURL=url;
        this.USERNAME=username;
        this.PASSWORD=password;
        connect = new Connecting(DBURL,USERNAME,PASSWORD);
    }

    public static void landlordAdd(String url,String username,String password,String [] information) throws SQLException {
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO Landlord ("
                    + " idLandlord,"
                    + " Name,"
                    + " Username,"
                    + " Password"
                    + " ) VALUES ("
                    + "?, ?, ?, ?)";
            System.out.println(query);
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

    public static void renterAdd(String url,String username,String password,String [] information) throws SQLException{
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO rrenter ("
                    + " idRenter,"
                    + " Name,"
                    + " Username,"
                    + " Password,"
                    + "Subscribe"
                    + " ) VALUES ("
                    + "?, ?, ?, ?, 0)";
            System.out.println(query);
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
                    + " Status,"
                    + " Address"
                    + " ) VALUES ("
                    + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            System.out.println(query);
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
                    + "?, ?, ?, ?,)";
            System.out.println(query);
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
                    + " Landlord_id,"
                    + " Renter_id,"
                    + " Message"
                    + " ) VALUES ("
                    + "?, ?, ? )";
            System.out.println(query);
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

    public static void messageRemove(String url, String username, String password, String  lordID,String renterID) throws SQLException{
        Update updt = new Update(url, username, password);
        try{

            String query = "DELETE FROM messages WHERE Landlord_id = ? AND Renter_id = ? ";
            PreparedStatement mystmt = updt.connect.getDbConnect().prepareStatement(query);
            mystmt.setString(1, lordID);
            mystmt.setString(2, renterID);
//
//            // update the arraylists and close connection
            mystmt.executeUpdate();
            updt.connect.close();


        }catch (SQLException e){
            updt.connect.close();
            e.printStackTrace();
        }

    }
    public static void propertyAmountAdd(String url,String username,String password,String [] information){
        Update updt = new Update(url,username,password);
        try{
            String query = "INSERT INTO property_amount ("
                    + " Propertyid,"
                    + " Landlord_id,"
                    + " Amount,"
                    + " Period"
                    + " ) VALUES ("
                    + "?, ?, ?, )";
            System.out.println(query);
            PreparedStatement myStmt = updt.connect.getDbConnect().prepareStatement(query);
            myStmt.setString(1,information[0]);
            myStmt.setString(2,information[1]);
            myStmt.setDouble(3,Double.parseDouble(information[2]));
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
            System.out.println(query);
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
