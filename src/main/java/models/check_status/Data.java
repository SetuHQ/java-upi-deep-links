package models.check_status;

class Data {
    private final String createdAt;
    private final String expiresAt;
    private final String name;
    private final PaymentLink paymentLink;
    private final String platformBillID;
    private final String status;

    public Data(String createdAt, String expiresAt, String name, PaymentLink paymentLink, String platformBillID, String status) {
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.name = name;
        this.paymentLink = paymentLink;
        this.platformBillID = platformBillID;
        this.status = status;
    }

    String getCreatedAt() {
        return createdAt;
    }

    String getExpiresAt() {
        return expiresAt;
    }

    String getName() {
        return name;
    }

    PaymentLink getPaymentLink() {
        return paymentLink;
    }

    String getPlatformBillID() {
        return platformBillID;
    }

    String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Data {" +
                "createdAt : " + createdAt + " " +
                "expiresAt : " + expiresAt + " " +
                "name : " + name + " " +
                "paymentLink : " + paymentLink + " " +
                "platformBillID : " + platformBillID + " " +
                "status : " + status + " " +
                "}";
    }
}
