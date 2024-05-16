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


    /**
     * Validates that the given cpf is valid.
     * 
     * @param cpf The cpf to validate.
     * @throws EmptyOrNullElementException if the cpf is null or empty.
     */
    public static void isValidCPF(String cpf) throws EmptyOrNullElementException {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new EmptyOrNullElementException("Empty or Null Name");
        } 
    }

    /**
     * Validates that the given password is valid.
     * 
     * @param password The password to validate.
     * @throws EmptyOrNullElementException if the password is null or empty.
     */
    public static void isValidPassword(String password) throws EmptyOrNullElementException {
        if (password == null || password.trim().isEmpty()) {
            throw new EmptyOrNullElementException("Empty or Null Name");
        } 
    }
}
