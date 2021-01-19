package models.generate_link;

public class GenerateLinkRequest {
    private final int amount;
    private final String expiryDate;
    private final String payeeName;
    private final String refId;
    private final String exactness;

    public GenerateLinkRequest(int amount, String expiryDate, String payeeName, String refId, String exactness) {
        this.amount = amount;
        this.expiryDate = expiryDate;
        this.payeeName = payeeName;
        this.refId = refId;
        this.exactness = exactness;
    }

    private String validationRules(String exactness, double amount) {
        String exactUp = "{\"amount\": " + "{\"maximum\" : \"0\", " + "\"minimum\": " + amount + "}}";
        String exactDown = "{\"amount\":" + " {\"minimum\" : \"0\"," + " \"maximum\": " + amount + "}}";

        if (exactness.equals("EXACT_UP")) {
            return exactUp;
        }
        return exactDown;
    }

    public String generateLinkJson() {
        String jsonInputString = "{" + "\"amount\": {\"currencyCode\" : \"INR\", \"value\": " + amount + "},"
                + "\"amountExactness\": \"" + exactness + "\"," +
                "\"billerBillID\": \"" + refId + "\","
                + "\"dueDate\": \"" + expiryDate + "Z\","
                + "\"expiryDate\": \"" + expiryDate + "Z\","
                + "\"name\": \"" + payeeName + "\"";

        if (!exactness.equals("EXACT")) {
            jsonInputString += ",\"validationRules\": " + validationRules(exactness, amount);
        }

        jsonInputString += "}";
        return jsonInputString;
    }
}
