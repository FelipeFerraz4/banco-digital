package com.bluefox.utils.validations;

import com.bluefox.exception.validations.InvalidElementException;

public class OperationValidation {
    /**
     * Validates that the given value is valid.
     * 
     * @param value The value to validate.
     * @throws InvalidElementException if the value is less than or equal to zero.
     */
    public static void isValidValue(double value) throws InvalidElementException {
        if (value <= 0) {
            throw new InvalidElementException("Value less than or equal to zero");
        } 
    }
}
