package net.kuehldesign.backuptube.exception;

public class MalformedFeedURLException extends Exception {
    String message = "undefined";

    public MalformedFeedURLException(String message) {
        setMessage(message);
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
