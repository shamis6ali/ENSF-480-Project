package Model;

public class Property_amount {
    private String propertyId;
    private String landlordId;
    private double amount;
    private String period;

    public Property_amount(String propertyId, String landlordId,
                           double amount, String period) {
        this.propertyId = propertyId;
        this.landlordId = landlordId;
        this.amount = amount;
        this.period = period;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public String getLandlordId() {
        return landlordId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPeriod() {
        return period;
    }

}
