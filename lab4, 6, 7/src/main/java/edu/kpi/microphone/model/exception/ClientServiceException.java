package edu.kpi.microphone.model.exception;

public class ClientServiceException extends Exception {
    public ClientServiceException() {
        super();
    }

    public ClientServiceException(String message) {
        super(message);
    }

    public ClientServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClientServiceException(Throwable cause) {
        super(cause);
    }
}
