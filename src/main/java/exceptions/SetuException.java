package exceptions;

public abstract class SetuException extends Exception {
    private String requestId;
    private Integer statusCode;

    protected SetuException(String message, String requestId, Integer statusCode) {
        this(message, requestId, statusCode, null);
    }

    protected SetuException(String message, String requestId, Integer statusCode, Throwable e) {
        super(message, e);
        this.requestId = requestId;
        this.statusCode = statusCode;
    }

    /**
     * Returns a String representation of the error.
     *
     * @return Error string
     * */
    @Override
    public String getMessage() {
        String additionalInfo = "";
        if (statusCode != null) {
            additionalInfo += ";code :" + statusCode;
        }
        return super.getMessage()+additionalInfo;
    }
}
