package models.check_status;

public class PaymentLink {
    private final String upiID;
    private final String upiLink;

    public PaymentLink(String upiID, String upiLink) {
        this.upiID = upiID;
        this.upiLink = upiLink;
    }

    String getUpiID() {
        return upiID;
    }

    String getUpiLink() {
        return upiLink;
    }
}
