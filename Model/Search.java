package Model;
import java.util.*;
public class Search  {
    private String type;
    private double bed;
    private double bath;
    private int furn;
    private int unfurn;
    private String quad;
    private ImportData datab;
    private List<Property> properties;
    private List<SearchCriteria> criteria;


    public void updateLists(){
        //datab.update();
        properties = datab.getProperties();
        criteria = datab.getSearches();
    }

    /*
     *  The function will iterate the properties and check for matching search criteria
     *  @param idRenter  to check which search criteria the renter associates with
     *  @return returns a list of property id strings that matches the search criteria
     *          returns null otherwise
     *
     */

    public List<String> doSearch(String idRenter){
    updateLists();
        List<String> temp = new ArrayList<>();
        if(!criteria.contains(idRenter)){
            throw new RuntimeException("idRenter not found");
        }

        SearchCriteria search = criteria.get(criteria.indexOf(idRenter));

        this.type = search.getApartmentType();
        this.bed = search.getNoOfBedrooms();
        this.bath = search.getNoOfBathrooms();
        this.furn = search.getFurnished();
        this.unfurn = search.getUnfurnished();
        this.quad = search.getCityQuadrant();
        for(Property p : properties){//iterate each property
            //essentially if a criteria is not matching, we immediately move to the next iteration
            // making sure the 'any' criteria is also not selected.
            //if all the criteria matches, then we will add the property id to the temp list

            if(!p.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
            else if(p.getNoOfBedrooms() != bed && bed != 0)continue;
            else if(p.getNoOfBathrooms() != bath && bath != 0)continue;
            else if (p.getFurnished() != furn && (unfurn == 0))continue;//make sure both furn and unfurn aren't 1
            else if(p.getUnfurnished() != unfurn && (furn == 0))continue;
            else if (!p.getCityQuadrant().equals(quad) && !quad.equals(("any")))continue;//same idea as checking 'type'
            else temp.add(p.getIdProperty());
        }

        if(temp.size() != 0) return temp;
        else return null;




    }




}
