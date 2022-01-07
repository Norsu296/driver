package pl.kuba.drive.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(ControllerException.class)
    public ResponseEntity<ErrorInfo> handleException(ControllerException e) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if (ErrorMessage.NOT_FOUND.equals(e.getError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        if (ErrorMessage.RESOURCE_EXISTS.equals(e.getError())){
            httpStatus = HttpStatus.CONFLICT;
        }
        if(ErrorMessage.BAD_REQUEST.equals(e.getError())){
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new ErrorInfo(e.getError().getMessage()));
    }
}
