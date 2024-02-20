package de.neuefische.springexceptionhandlingtask;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleIllegalArgumentException(IllegalArgumentException exception) {

        ErrorMessage errorMessage = new ErrorMessage(
                exception.getMessage(),
                HttpStatus.METHOD_NOT_ALLOWED,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException exception){

        ErrorMessage errorMessage = new ErrorMessage(
                exception.getMessage(),
                HttpStatus.I_AM_A_TEAPOT,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorMessage, HttpStatus.I_AM_A_TEAPOT);
    }
}
