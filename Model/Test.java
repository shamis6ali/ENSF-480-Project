package Model;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {

        ImportData testData =  new ImportData("jdbc:mysql://127.0.0.1:3306/test",
                "tom","password");

//        List<Landlord> landList = testData.getLandlords();
//
//        for(int i=0;i<landList.size();i++){
//            System.out.println(landList.get(i).getIdLandlord()+" "+landList.get(i).getName()+" "+
//                    landList.get(i).getUsername()+" "+landList.get(i).getPassword());
//            System.out.println();
//        }

        // BELOW IS SHOWN HOW YOU USE setStatus METHOD FOR PROPERTIES

        //Update.setStatus("jdbc:mysql://127.0.0.1:3306/Online_Rental","root","root","prop06","Cancelled");

        // BELOW IS SHOWN HOW YOU USE setSubscribeOn METHOD FOR PROPERTIES SAME IS HOW YOU USE setSubscribeOff

        //Update.setSubscribeOn("jdbc:mysql://127.0.0.1:3306/Online_Rental","root","root","NiTSs05");

//        List<SearchCriteria> search = testData.getSearches();
//
//        System.out.println(search.get(2).getIdRenter());
//
//        String str[]={"Rt7y48","Wilkson","Wkou45","somepass"};
//
//        Update.landlordAdd("jdbc:mysql://127.0.0.1:3306/Online_Rental",
//                "root","root",str);

        List<SearchCriteria> search = testData.getSearches();
        List<Property> properties = testData.getProperties();
        Search tempSearch = new Search(testData);
        for(SearchCriteria s : search){
            System.out.println(s.getIdRenter());
        }

        for(Property p : properties){
            System.out.println(p.getIdProperty());
        }
        String newprop[] = {"aswe21", "BlDy02", "Mansion", "11", "7.5", "1", "0", "SW","Active","awesomewill 69"};
        String str[]={"Rt7y48","Wilkson","Wkou45","somepass"};
//        Update.propertyAdd("jdbc:mysql://127.0.0.1:3306/test", "tom", "password", newprop);
//        Update.landlordAdd("jdbc:mysql://127.0.0.1:3306/test", "tom", "password", str);
//        Update.propertyRemove("jdbc:mysql://127.0.0.1:3306/test", "tom", "password", "aswe21");
        String renter[] = {"123sdasd", "Sh ee", "User", "pass"};
       // Update.renterAdd("jdbc:mysql://127.0.0.1:3306/test", "tom", "password", renter);
        String message[] = {"BlDy02", "BgTs02", "This is a test message"};
       // Update.messageAdd("jdbc:mysql://127.0.0.1:3306/test", "tom", "password", message);
        Update.messageRemove("jdbc:mysql://127.0.0.1:3306/test", "tom", "password", "BlDy02", "BgTs02");



//        properties = testData.getProperties();
//        for(Property p : properties){
//            System.out.println(p.getIdProperty());
//        }
//        if(tempSearch.checkPropertyCriteria("Apartment", 2,1.5,0,1,"SE")){
//            System.out.println("Property Found");
//        }else{
//            System.out.println("Not found");
//        }



        //System.out.println(search.get(2).getIdRenter());


    }
}
