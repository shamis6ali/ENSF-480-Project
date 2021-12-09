package Model;

import java.sql.SQLException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException {

        ImportData testData =  new ImportData("jdbc:mysql://127.0.0.1:3306/Online_Rental",
                "root","root");

//        List<Landlord> landList = testData.getLandlords();
//
//        for(int i=0;i<landList.size();i++){
//            System.out.println(landList.get(i).getIdLandlord()+" "+landList.get(i).getName()+" "+
//                    landList.get(i).getUsername()+" "+landList.get(i).getPassword());
//            System.out.println();
//        }

        List<SearchCriteria> search = testData.getSearches();

        System.out.println(search.get(2).getIdRenter());

    }
}
