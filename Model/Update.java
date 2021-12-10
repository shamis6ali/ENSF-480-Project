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


    public static void landlordRemove(String url, String username, String password, String [] information) throws SQLException{
    Update updt = new Update(url, username, password);

    }

}
