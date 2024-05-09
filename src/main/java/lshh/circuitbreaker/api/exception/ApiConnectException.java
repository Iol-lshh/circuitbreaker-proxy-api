package lshh.circuitbreaker.api.exception;

public class ApiConnectException extends RuntimeException {
    public ApiConnectException(String message) {
        super(message);
    }

    public ApiConnectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiConnectException() {
        super("API connection failed.");
    }
}
