package models.generate_link;

class Data {
    private final String name;
    private final String platformBillID;
    private final PaymentLink paymentLink;

    public Data(String name, String platformNameId, PaymentLink paymentLink) {
        this.name = name;
        this.platformBillID = platformNameId;
        this.paymentLink = paymentLink;
    }

    public String getName() {
        return name;
    }

    public String getPlatformBillID() {
        return platformBillID;
    }

    public PaymentLink getPaymentLink() {
        return paymentLink;
    }
}
