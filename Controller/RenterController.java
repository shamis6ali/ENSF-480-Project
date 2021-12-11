//package Controllers;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.awt.event;
//
//import views.RenterView; //combine SearchView and Email View to RenterView instead
//import Model.*;
////import models.Database;
////import models.Property;
////import models.Search;
//
//public class RenterController { //implements ActionaListener?
//    private RenterView view;
//
//    public RenterController(Database model, RenterView view) {
//        super(model);
//        this.view = view;
//        addListeners();
//    }
//
//    public RenterController(Database model) {
//        super(model);
//        addListeners();
//    }
//
//    private void addListeners() {
//        //change name of listeners and button according to Momin's implementation
//        renterView.addButtonListener (e -> propertySearch(this.view));//displays properties that match the search
//    }
//
//    public void search(RenterView view) {
//        int bathrooms = Integer.parseInt(view.getBathroomsInput); //can I do this? it will be a string initially right?
//        int bedrooms = Integer.parseInt(view.getBedroomsInput);
//        int furnished = Integer.parseInt(view.getFurnishedInput); //0=false, 1=true
//        String quadrant = view.getQuadrantInput;
//        ArrayList<Property> properties = new ArrayList<Property>();
//        //add dummy data here to test functionality; otherwise test with data
//
//        try {
//            if (view == null) { //no input
//                System.out.println("view is null");
//            } else if (bathrooms == null || bathrooms <= 0) {
//                System.out.println("please enter the number of bathrooms");
//            } else if (bedrooms == null || bedrooms <= 0) {//initialize integers before or after this try block?
//                System.out.println("please enter the number of bedrooms");
//            } else if (furnished != 0 || furnished != 1) {//initialize integers before or after this try block?
//                System.out.println("please enter furnishing preferences");
//            }
//        } catch (NumberFormatException e) {
//            view.displayError("Please enter a valid input for bedrooms, bathrooms, and furnished");//display error view!
//            return;
//        }
//
//        properties = models.search(bathrooms, bedrooms, furnished, quadrant);
//        if (properies == null) {
//            System.out.println("no matches found");
//            throw new NullPointerException;
//        }
//    }
//
//    public void contactLandlord(RenterView view) {
//        int propID = Integer.parseInt(view.getPropID());
//        String email = view.getEmailInput();
//        String content = view.getContent();
//
//        try {
//            if (propID == null) {
//                System.out.println("please enter the propID of the property you are interested in");
//            } else if (email== null) {
//                System.out.println("please enter the email you can be contacted at");
//            } else if (content == null) {
//                System.out.println("please enter a message");
//            }
//        } catch (e) {
//            e.printStackTrace();
//        }
//
//        models.contactLandlord(propID, email, content);
//    }
//}
