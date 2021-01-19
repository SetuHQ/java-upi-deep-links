package models.generate_link;

import models.DeeplinkError;

import java.util.Objects;

public class GenerateLinkResponse {
    private final String status;
    private final Boolean success;
    private final Data data;
    private final DeeplinkError deeplinkError;

    public GenerateLinkResponse(String status, Boolean success, Data data, DeeplinkError deeplinkError) {
        this.status = status;
        this.success = success;
        this.data = data;
        this.deeplinkError = deeplinkError;
    }

    public String getStatus() {
        return status;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getName() {
        if (data == null) {
            return "Empty";
        }
        return data.getName();
    }

    public String getUpiId() {
        if (data == null) {
            return "Empty UPI Id";
        }
        return Objects.requireNonNullElse(data.getPaymentLink().getUpiID(), "Empty");
    }

    public String getPlatformBillId() {
        if (data == null) {
            return "Empty platformBillId";
        }
        return Objects.requireNonNullElse(data.getPlatformBillID(), "Empty");
    }

    public String getError() {
        if (deeplinkError == null) {
            return "No error";
        }
        return deeplinkError.getTitle();
    }

    @Override
    public String toString() {
        return "GenerateLinkResponse status : " + status + " " +
                "success : " + success + " " +
                "name : " + getName() + " " +
                "upiId : " + getUpiId() + " " +
                "platformBillId : " + getPlatformBillId() +
                "error : " + getError()
                ;
    }
}
