package net.kuehldesign.backuptube.exception;

public class UnableToGetSourceException extends Exception {
    String message = "undefined";

    public UnableToGetSourceException(String message) {
        setMessage(message);
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
