package models;

public class MockPayment {
    private final int amount;
    private final String upiID;

    public MockPayment(int amount, String upiID, String sourceAccountId) {
        this.amount = amount;
        this.upiID = upiID;
    }

    public String getMockPaymentJson() {
        return "{" + "\"amount\" :" + amount + ","
                + "\"destinationAccount\": {\"accountID\" : \"" + upiID + "\"},"
                + "\"sourceAccount\": { \"accountID\" : \"customer@vpa\"}," + "\"type\" : \"UPI\"" + "}";
    }
}
