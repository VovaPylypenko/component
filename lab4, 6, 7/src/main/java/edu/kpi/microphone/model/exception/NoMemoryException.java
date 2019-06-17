package edu.kpi.microphone.model.exception;

public class NoMemoryException extends ClientServiceException {
    public NoMemoryException() {
    }

    public NoMemoryException(String message) {
        super(message);
    }

    public NoMemoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoMemoryException(Throwable cause) {
        super(cause);
    }
}
