package models.check_status;

public class CheckStatusResponse {
    private final String status;
    private final Boolean success;
    private final Data data;
    private final Error error;

    public CheckStatusResponse(String status, Boolean success, Data data, Error error) {
        this.status = status;
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public String getRequestStatus() {
        return status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getCreatedAt() {
        if (data == null) {
            return "";
        }
        return data.getCreatedAt();
    }

    public String getExpiresAt() {
        if (data == null) {
            return "";
        }
        return data.getExpiresAt();
    }

    public String getName() {
        if (data == null) {
            return "";
        }
        return data.getName();
    }

    public String getUpiID() {
        if (data == null) {
            return "";
        }
        return data.getPaymentLink().getUpiID();
    }

    public String getUpiLink() {
        if (data == null) {
            return "";
        }
        return data.getPaymentLink().getUpiLink();
    }

    public String getPlatformBillID() {
        if (data == null) {
            return "";
        }
        return data.getPlatformBillID();
    }

    public String getBillStatus() {
        if (data == null) {
            return "";
        }
        return data.getStatus();
    }

    public Error getError() {
        return error;
    }

    @Override
    public String toString() {
        return "CheckStatus [" +
                "status : " + status + " " +
                "success : " + success + " " +
                "data : " + data.toString() + " " +
                "]";
    }
}
