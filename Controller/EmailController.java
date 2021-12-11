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
        String info[] = {propID, email, message};
        Update.messageAdd(dbsPath, dbsUser,dbsPass, info);
        System.out.println("message sent!");
    }

    public EmailController(String email) {//for landlords
        this.email = email;
        emailRenter();
    }
    public void emailRenter() {
        List<Messages> listEmails= model.getMessages();
        for (int i = 0; i < listEmails.size(); i++) {
            if (this.email.equals(listEmails.get(i).getEmail())) {
                System.out.println("message sent!");
            } else {
                System.out.println("you have never been contacted by this email!");
            }
        }
    }
}
