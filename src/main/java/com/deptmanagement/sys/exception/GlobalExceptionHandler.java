package com.deptmanagement.sys.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p> Global exception handler to manage application-wide exceptions. </p>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * <p> Handles EntityNotFoundException and returns a NOT_FOUND response. </p>
     *
     * @param ex <p> The exception thrown when an entity is not found. </p>
     * @return <p> ResponseEntity with error message and HTTP status NOT_FOUND. </p>
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFound(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    /**
     * <p> Handles all other exceptions and returns an INTERNAL_SERVER_ERROR response. </p>
     *
     * @param ex <p> The exception that was thrown. </p>
     * @return <p> ResponseEntity with error message and HTTP status INTERNAL_SERVER_ERROR. </p>
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
