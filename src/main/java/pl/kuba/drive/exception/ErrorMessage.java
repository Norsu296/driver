package pl.kuba.drive.exception;

public enum ErrorMessage {

    NOT_FOUND("Resource does not exist");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
