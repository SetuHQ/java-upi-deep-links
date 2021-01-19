package exceptions;

public class AuthException extends SetuException {
    public AuthException(String message, String requestId, Integer statusCode) {
        super(message, requestId, statusCode);
    }
}
