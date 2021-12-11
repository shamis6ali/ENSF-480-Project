package Controller;

import Model.*;

import java.util.List;

public class FeeController {
    String dbsUser = "root";
    String dbsPass = "Hiba0105!";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/Property_Rental";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    /**
     *
     * @param amount
     */
    public void changeAmount (double amount){
        Update.setPropertyAmount(amount);
    }

    /**
     *
     * @param period
     */
    public void changePeriod (String period){
        Update.setPropertyAmount(period);
    }

    /**
     * sets amount and period
     * @param amount
     * @param period
     */
    public void changeBoth (double amount, String period) {
        Update.setPropertyAmount(amount, period);
    }

}
