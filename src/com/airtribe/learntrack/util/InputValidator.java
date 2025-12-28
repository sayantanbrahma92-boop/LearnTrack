package com.airtribe.learntrack.util;

import com.airtribe.learntrack.exception.InvalidInputException;

public class InputValidator {

    private InputValidator() {
        // prevent object creation
    }

    public static void validateString(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be empty.");
        }
    }

    public static void validatePositiveNumber(int value, String fieldName) {
        if (value <= 0) {
            throw new InvalidInputException(fieldName + " must be greater than zero.");
        }
    }

    public static void validateId(Long id, String fieldName) {
        if (id == null || id <= 0) {
            throw new InvalidInputException("Invalid " + fieldName + ".");
        }
    }
}
