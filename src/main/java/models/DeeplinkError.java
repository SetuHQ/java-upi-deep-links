package models;

import java.util.List;

public class DeeplinkError {
    private final String code;
    private final String detail;
    private final String docURL;
    private final String title;
    private final List<String> errors;
    private final String traceId;

    private DeeplinkError(String code, String detail,
                          String docURL, String title,
                          List<String> errors, String traceId) {
        this.code = code;
        this.detail = detail;
        this.docURL = docURL;
        this.title = title;
        this.errors = errors;
        this.traceId = traceId;
    }

    public String getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }

    public String getDocURL() {
        return docURL;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getTraceId() {
        return traceId;
    }
}