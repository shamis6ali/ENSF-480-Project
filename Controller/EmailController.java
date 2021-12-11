package Controller;



import Model.*;

import java.sql.SQLException;
import java.util.List;
import java.util.*;

import static Controller.LoginController.USER;

public class EmailController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);
    String propID;
    String email;
    String message;
    
    public EmailController(String propID, String email, String message) { //for renters
        this.propID = propID;
        this.email = email;
        this.message=message;
    }
    public void send() {

        System.out.println("message sent!");
    }

    public EmailController(String email) {//for landlords
        this.email = email;
        emailRenter();
    }
    public void emailRenter() {
    
        System.out.println("message sent!");
    
    }
}
