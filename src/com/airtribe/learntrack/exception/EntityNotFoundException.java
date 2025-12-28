package com.airtribe.learntrack.exception;

/**
 * Thrown when a requested entity is not found in the system.
 */

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message){
        super(message);
    }
}