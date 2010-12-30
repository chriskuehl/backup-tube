package net.kuehldesign.backuptube.exception;

public class BadVideoException extends Exception {
    String message = "undefined";

    public BadVideoException(String message) {
        setMessage(message);
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
