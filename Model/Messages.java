package Model;

public class Messages {
    private String landlordId;
    private String renterId;
    private String message;

    public Messages(String landlordId, String renterId, String message) {
        this.landlordId = landlordId;
        this.renterId = renterId;
        this.message = message;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public String getRenterId() {
        return renterId;
    }

    public String getMessage() {
        return message;
    }


}
