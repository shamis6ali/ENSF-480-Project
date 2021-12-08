package Model;

public class SearchCriteria {
    private String idSearch;
    private String apartmentType;
    private double noOfBedrooms;
    private double noOfBathrooms;
    private int furnished;
    private int unfurnished;
    private String cityQuadrant;
    private String idRenter;

    public SearchCriteria(String idSearch, String apartmentType,
                          double noOfBedrooms, double noOfBathrooms,
                          int furnished, int unfurnished,
                          String cityQuadrant, String idRenter) {
        this.idSearch = idSearch;
        this.apartmentType = apartmentType;
        this.noOfBedrooms = noOfBedrooms;
        this.noOfBathrooms = noOfBathrooms;
        this.furnished = furnished;
        this.unfurnished = unfurnished;
        this.cityQuadrant = cityQuadrant;
        this.idRenter = idRenter;
    }

    public String getIdSearch() {
        return idSearch;
    }

    public String getApartmentType() {
        return apartmentType;
    }

    public double getNoOfBedrooms() {
        return noOfBedrooms;
    }

    public double getNoOfBathrooms() {
        return noOfBathrooms;
    }

    public int getFurnished() {
        return furnished;
    }

    public int getUnfurnished() {
        return unfurnished;
    }

    public String getCityQuadrant() {
        return cityQuadrant;
    }

    public String getIdRenter() {
        return idRenter;
    }
}
