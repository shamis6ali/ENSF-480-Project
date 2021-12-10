package Controller;

import Model.ImportData;
import Model.Landlord;
import Model.importData;
import Model.Update;
import views.*;

import java.util.List;

public class LoginController {
    private RenterLoginView rView;
    private LandlordLoginView lView;
    private ManagerLoginView mView;

    public LoginController(ImportData model, RenterLoginView view) {
        super(model);
        this.rView = view;
        start();

    }

    public LoginController(ImportData model, LandlordLoginView view) {
        super(model);
        this.lView = view;
        start();

    }

    public LoginController(ImportData model, ManagerLoginView view) {
        super(model);
        this.mView = view;
        start();
    }

    public void start() {
        view.addLoginListener( e -> login(view.getUsernameInput(), view.getPasswordInput()));
    }

    public void rLogin(String username, String password) {
        List<Landlord> rentList = model.getRegisteredRenters();
        boolean valid = false;
        for (int i = 0; i < rentList.size(); i++) {
            if (username == rentlist.get(i).getUsername() && password == rentList.get(i).getPassword())
                valid = true;
        }
        if (valid) {
            System.out.println("valid renter");
            dispose();//ensure this works!
            RegisteredRenterController renter = new RegisteredRenterController(model, new RenterView());
        } else {
            System.out.println("invalid renter");
            view.dialogue("Error: Invalid Login");
        }
    }

    public void mLogin(String username, String password) {
        List<Landlord> mgrList = model.getManagers();
        boolean valid = false;
        for (int i = 0; i < mgrList.size(); i++) {
            if (username == mgrList.get(i).getUsername() && password == mgrList.get(i).getPassword())
                valid = true;
        }
        if (valid) {
            System.out.println("valid manager");
            dispose();//ensure this works!
            ManagerController manager = new ManagerController(model, new ManagerView());
        } else {
            System.out.println("invalid manager");
            view.dialogue("Error: Invalid Login");
        }
    }

    public void lLogin(String username, String password) {
        List<Landlord> landList = model.getLandlords();
        boolean valid = false;
        for (int i = 0; i < landList.size(); i++) {
            if (username == landList.get(i).getUsername() && password == landList.get(i).getPassword())
                valid = true;
        }
        if (valid) {
            System.out.println("valid landlord");
            dispose();//ensure this works!
            LandlordController landlord = new LandlordController(model, new LandLordView());
        } else {
            System.out.println("invalid landlord");
            view.dialogue("Error: Invalid Login");
        }
    }

}