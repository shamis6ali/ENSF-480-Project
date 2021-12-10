//
//import java.util.ArrayList;
//
//import views.RegisteredRenterView;
//import views.RenterView;
//
//import models.Database;
//import models.Property;
//
//public class RegisteredRenterController extends RenterController {
//    private RegisteredRenterView view;
//    private UserController login;
//    private String username;
//    private String password;
//
//    public RegisteredRenterController(Database model, RegisteredRenterView view, LoginController login,
//            String username, String password) {
//        super(model);
//        this.view = view;
//        this.login = login;
//        this.username = username;
//        this.password = password;
//
//    }
//
//    @Override
//    public void addListener() {
//        view.addButtonListener(e -> propertySearch(this.view));
//        view.addLogoutListener(e -> { view.dispose();
//                        login.start();
//        });
//        view.addSearchListener(e -> view.displaySearchPanel());
//        view.addUnsubscribeListener(e -> unsubscribeRenter());
//
//        view.addSubsribeListener(e -> view.NotificationsPanel(model.getRenterNotifications(username)));
//    }
//
//
//    public void unsubscribeRenter() {
//        view.("You have been unsubscribed");//or system.o.println
//        model.unsubscribeNotification(username);
//    }
//
//    public RegisteredRenterView getView() {
//        return this.view;
//    }
//
//    public void setView(RegisteredRenterView view) {
//        this.view = view;
//    }
//
//    public LoginController getLogin() {
//        return this.login;
//    }
//
//    public void setLogin(LoginController login) {
//        this.login = login;
//    }
//
//    public String getUsername() {
//        return this.username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return this.password;
//    }
//
//    public void setPassowrd (String password) {
//        this.password = password;
//    }
//
//}