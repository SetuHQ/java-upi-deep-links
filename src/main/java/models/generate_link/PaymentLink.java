package models.generate_link;

class PaymentLink {
    private final String shortURL;
    private final String upiID;
    private final String upiLink;

    public PaymentLink(String shortURL, String upiID, String upiLink) {
        this.shortURL = shortURL;
        this.upiID = upiID;
        this.upiLink = upiLink;
    }

    public String getShortURL() {
        return shortURL;
    }

    public String getUpiID() {
        return upiID;
    }

    public String getUpiLink() {
        return upiLink;
    }
}