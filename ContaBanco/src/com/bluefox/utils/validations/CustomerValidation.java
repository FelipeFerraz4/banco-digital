package com.bluefox.utils.validations;

import java.util.regex.Pattern;

import com.bluefox.exception.validations.EmptyOrNullElementException;
import com.bluefox.exception.validations.InvalidElementException;

public class CustomerValidation {
    // Defining the standard, compiling it once for reuse
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-ZÀ-ÖØ-öø-ÿ]+([ '-][a-zA-ZÀ-ÖØ-öø-ÿ]+)*$");

    /**
     * Validates that the given name is valid.
     * 
     * @param name The name to validate.
     * @throws EmptyOrNullElementException if the name is null or empty.
     * @throws InvalidElementException if the name does not match the allower pattern.
     */

    public static void isValidName(String name) throws EmptyOrNullElementException, InvalidElementException {
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyOrNullElementException("Empty or Null Name");
        } else if (!NAME_PATTERN.matcher(name.trim()).matches()) {
            throw new InvalidElementException("Invalid Name");
        }
    }
}
