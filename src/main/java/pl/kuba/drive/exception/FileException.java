package pl.kuba.drive.exception;

import java.io.IOException;

public class FileException extends IOException {

    private ErrorMessage errorMessage;

    public FileException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ErrorMessage getError(){
        return errorMessage;
    }

}
