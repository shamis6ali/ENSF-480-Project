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

        List<SearchCriteria> search = testData.getSearches();
        List<Property> properties = testData.getProperties();
        Search tempSearch = new Search(testData);
        for(SearchCriteria s : search){
            System.out.println(s.getIdRenter());
        }

        for(Property p : properties){
            System.out.println(p.getIdProperty());
        }
        System.out.println("Before remove");
        testData.removeEntity("property","idProperty","prp02");
        System.out.println("After remove");
        properties = testData.getProperties();
        for(Property p : properties){
            System.out.println(p.getIdProperty());
        }
//        if(tempSearch.checkPropertyCriteria("Apartment", 2,1.5,0,1,"SE")){
//            System.out.println("Property Found");
//        }else{
//            System.out.println("Not found");
//        }



        //System.out.println(search.get(2).getIdRenter());

    }
}
