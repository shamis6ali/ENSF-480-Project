package Model;
import java.util.*;
public class Search  {
    private String type;
    private int bed;
    private int bath;
    private boolean furn;
    private String quad;
    private ImportData datab;
    private List<Property> properties;
    private List<SearchCriteria> criteria;


    public void updateLists(){
        //datab.update();
        properties = datab.getProperties();
        criteria = datab.getSearches();
    }
    public Search(String type, int bed, int bath, boolean furn, String quad) {
        this.type = type;
        this.bed = bed;
        this.bath = bath;
        this.furn = furn;
        this.quad = quad;
    }


    public List<String> doSearch(String idRenter){
    updateLists();
        List<String> temp = new ArrayList<>();

        //for()



        if(temp == null) return null;
        else return temp;

    }




}
