package Model;

public class Property {
    private String idProperty;
    private String landlordId;
    private String apartmentType;
    private double noOfBedrooms;
    private double noOfBathrooms;
    private int furnished;
    private int unfurnished;
    private String cityQuadrant;
    private String status;
    private String address;

    public Property(String idProperty, String landlordId,
                    String apartmentType, double noOfBedrooms,
                    double noOfBathrooms, int furnished,
                    int unfurnished, String cityQuadrant,
                    String status, String address) {
        this.idProperty = idProperty;
        this.landlordId = landlordId;
        this.apartmentType = apartmentType;
        this.noOfBedrooms = noOfBedrooms;
        this.noOfBathrooms = noOfBathrooms;
        this.furnished = furnished;
        this.unfurnished = unfurnished;
        this.cityQuadrant = cityQuadrant;
        this.status = status;
        this.address = address;
    }

    public String getIdProperty() {
        return idProperty;
    }

    public String getLandlordId() {
        return landlordId;
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

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }
}
