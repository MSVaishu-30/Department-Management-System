package com.deptmanagement.sys.exception;

/**
 * <p> Custom exception for handling entity not found scenarios. </p>
 */
public class EntityNotFoundException extends RuntimeException {

    /**
     * <p> Constructor that accepts an error message. </p>
     *
     * @param message <p> Error message describing the exception. </p>
     */
    public EntityNotFoundException(String message) {
        super(message);
    }
}
