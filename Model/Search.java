package Model;
import java.util.*;
public class Search  {
    private String type;
    private double bed;
    private double bath;
    private int furn;
    private int unfurn;
    private String quad;
    private static ImportData datab;
    private List<Property> properties;
    private List<SearchCriteria> criteria;
    private List<RRenter> renters;


    public void updateLists(){
        //datab.update();
        properties = datab.getProperties();
        criteria = datab.getSearches();
        renters = datab.getRegistRenters();
    }
    public Search(){};
    public Search(ImportData d){
        datab = d;
    }

    /**
     *  The function will iterate the properties and check for matching search criteria
     *  @param idRenter  to check which search criteria the renter associates with
     *  @return  a list of property id strings that matches the search criteria
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
            if(!p.getStatus().equals("Active")) continue;
            else if(!p.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
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

    /**
        This function will check if a property exists based on property criteria
    * All the param will be the search criteria for a property
    * @return true if property with given criteria exists, false otherwise
     */
    public boolean checkPropertyCriteria(String apartmentType, double noOfBedrooms,
                                         double noOfBathrooms, int furnished,
                                         int unfurnished, String cityQuadrant
                                          ) {

        updateLists();
        this.type = apartmentType;
        this.bed = noOfBedrooms;
        this.bath = noOfBathrooms;
        this.furn = furnished;
        this.unfurn = unfurnished;
        this.quad = cityQuadrant;

        for(Property p : properties){//iterate each property
            if(!p.getStatus().equals("Active")) continue;
            else if(!p.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
            else if(p.getNoOfBedrooms() != bed && bed != 0)continue;
            else if(p.getNoOfBathrooms() != bath && bath != 0)continue;
            else if (p.getFurnished() != furn && (unfurn == 0))continue;//make sure both furn and unfurn aren't 1
            else if(p.getUnfurnished() != unfurn && (furn == 0))continue;
            else if (!p.getCityQuadrant().equals(quad) && !quad.equals(("any")))continue;//same idea as checking 'type'
            else return true;
        }
    return false;
    }

    /**
     *
     * @param s
     * @return returns true if search criteria s matches any properties in the database
     * false otherwise
     */
    public boolean checkPropertySearchCriteria(SearchCriteria s){
        updateLists();
        this.type = s.getApartmentType();
        this.bed = s.getNoOfBedrooms();
        this.bath = s.getNoOfBathrooms();
        this.furn = s.getFurnished();
        this.unfurn = s.getUnfurnished();
        this.quad = s.getCityQuadrant();

        for(Property p : properties){
            if(!p.getStatus().equals("Active")) continue;
            else if(!p.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
            else if(p.getNoOfBedrooms() != bed && bed != 0)continue;
            else if(p.getNoOfBathrooms() != bath && bath != 0)continue;
            else if (p.getFurnished() != furn && (unfurn == 0))continue;//make sure both furn and unfurn aren't 1
            else if(p.getUnfurnished() != unfurn && (furn == 0))continue;
            else if (!p.getCityQuadrant().equals(quad) && !quad.equals(("any")))continue;//same idea as checking 'type'
            else return true;
        }
        return false;

    }

    /**
     *
     * @param type
     * @param furnished
     * @param unfurnished
     * @param quad
     * @param bed
     * @param bath
     * @return returns a list of property that matches all the arguments
     */
    public List<Property> returnSearchResults(String type, int furnished, int unfurnished, String quad, double bed, double bath ){
        List<Property> temp = new ArrayList<>();
        updateLists();
        this.type = type;
        this.bed = bed;
        this.bath = bath;
        this.furn = furnished;
        this.unfurn = unfurnished;
        this.quad = quad;

        for(Property p : properties){
            if(!p.getStatus().equals("Active")) continue;
            else if(!p.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
            else if(p.getNoOfBedrooms() != bed && bed != 0)continue;
            else if(p.getNoOfBathrooms() != bath && bath != 0)continue;
            else if (p.getFurnished() != furn && (unfurn == 0))continue;//make sure both furn and unfurn aren't 1
            else if(p.getUnfurnished() != unfurn && (furn == 0))continue;
            else if (!p.getCityQuadrant().equals(quad) && !quad.equals(("any")))continue;//same idea as checking 'type'
            else temp.add(p);
        }

        if(temp.size() != 0) return temp;
        else return null;

    }

    /**
     *
     * @param pr An array of strings that constructs a property in the database
     * @return Will return emails of all users that has the matching search criteria of the property
     */
    public  List<String> checkNewPropertyFromSearchCriteria(String[] pr){
        List<String> temp = new ArrayList<>();
        this.type = pr[0];
        this.bed = Double.parseDouble(pr[1]);
        this.bath = Double.parseDouble(pr[2]);
        this.furn = Integer.parseInt(pr[3]);
        this.unfurn = Integer.parseInt(pr[4]);
        this.quad = pr[5];
        updateLists();
        for(SearchCriteria s : criteria){//iterate each property

             if(!s.getApartmentType().equals(type)  && !type.equals("any"))continue;//make preference isn't 'any if it doesn't match
            else if(s.getNoOfBedrooms() != bed && bed != 0)continue;
            else if(s.getNoOfBathrooms() != bath && bath != 0)continue;
            else if (s.getFurnished() != furn && (unfurn == 0))continue;//make sure both furn and unfurn aren't 1
            else if(s.getUnfurnished() != unfurn && (furn == 0))continue;
            else if (!s.getCityQuadrant().equals(quad) && !quad.equals(("any")))continue;//same idea as checking 'type'
            else temp.add(renters.get(renters.indexOf(s.getIdRenter())).getEmail());
        }

        if(temp.size() != 0) return temp;
        else return null;

    }





}//end of class
