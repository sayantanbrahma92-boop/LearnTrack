package com.airtribe.learntrack.exception;

/**
 * Thrown when input data is invalid or does not meet required criteria.
 */

public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String message){
        super(message);
    }
}