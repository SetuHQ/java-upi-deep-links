package exceptions;

public class RequestException extends SetuException{
    public RequestException(String message, String requestId, Integer statusCode) {
        super(message, requestId, statusCode);
    }
}
