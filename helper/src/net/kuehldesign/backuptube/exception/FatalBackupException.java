package net.kuehldesign.backuptube.exception;

public class FatalBackupException extends Exception {
    String message = "undefined";

    public FatalBackupException(String message) {
        setMessage(message);
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
