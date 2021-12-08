package Model;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connecting {
    /**
     * Username for the connection
     */
    private static String username;
    /**
     * Password for the connection
     */
    private static String password;
    /**
     * Database URL for inventory.sql
     */
    private static String dbUrl;
    /**
     * Connection object for the connection
     */
    private Connection dbConnect;
    /**
     * ResultSet type object for the results of the query
     */
    private ResultSet results;

    /**
     * Setter for the ResultSet object
     *
     * @param results
     */

    public void setResults(ResultSet results) {
        this.results = results;
    }

    /**
     * Getter for the ResultSet object
     */

    public ResultSet getResults() {
        return results;
    }

    /**
     * Constructor for the Connection class that allows to make a connection
     *
     * @param dburl    Database URL for the inventory.sql
     * @param username Username
     * @param password Password
     */

    public Connecting(String dburl, String username, String password) {
        Connecting.username = username;
        Connecting.password = password;
        Connecting.dbUrl = dburl;


        this.createConnection();

    }

    /**
     * Getter for the Connection object
     *
     * @return
     */
    public Connection getDbConnect() {
        return dbConnect;
    }

    /**
     * Created the connection to the actual database
     */

    private void createConnection() {
        try {
            dbConnect = (Connection) DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
             e.printStackTrace();
            // caught in UI
        }

    }

    /**
     * Safely closes the connection made allowing for the data to be secure
     */

    public void close() {
        try {
            if (results != null) {
                results.close();
            }

            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
