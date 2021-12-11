package Model;

public class Property_amount {
    private double amount;
    private String period;

    public Property_amount(double amount, String period) {
        this.amount = amount;
        this.period = period;
    }

    public double getAmount() {
        return amount;
    }

    public String getPeriod() {
        return period;
    }

}
