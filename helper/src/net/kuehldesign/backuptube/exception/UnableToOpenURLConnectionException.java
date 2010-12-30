package net.kuehldesign.backuptube.exception;

public class UnableToOpenURLConnectionException extends Exception {
    String message = "undefined";

    public UnableToOpenURLConnectionException(String message) {
        setMessage(message);
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
