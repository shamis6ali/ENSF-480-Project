package Controller;

import Model.*;

import java.util.List;

public class FeeController {
    String dbsUser = "tom";
    String dbsPass = "password";
    String dbsPath = "jdbc:mysql://127.0.0.1:3306/test";
    ImportData model = new ImportData(dbsPath,
            dbsUser,dbsPass);

    /**
     *
     * @param amount
     */
    public void changeAmount (double amount){
        Update.propertyAmountAdd(dbsPath,dbsUser,dbsPass,amount);
    }

    /**
     *
     * @param period
     */
    public void changePeriod (String period){
        Update.propertyPeriodAdd(dbsPath,dbsUser,dbsPass,period);
    }

    /**
     * sets amount and period
     * @param amount
     * @param period
     */
    public void changeBoth (double amount, String period) {
        Update.propertyAmountBoth(dbsPath,dbsUser,dbsPass,period,amount);
    }

}
