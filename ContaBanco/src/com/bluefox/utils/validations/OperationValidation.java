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

    /**
     * Validates that the given bankBranch is valid.
     * 
     * @param bankBranch The bankBranch to validate.
     * @throws InvalidElementException if the bankBranch is less than or equal to zero.
     */
    public static void isValidBankBranch(int bankBranch) throws InvalidElementException {
        if (bankBranch <= 0) {
            throw new InvalidElementException("BankBranch less than or equal to zero");
        } 
    }

    /**
     * Validates that the given accountNumber is valid.
     * 
     * @param accountNumber The accountNumber to validate.
     * @throws InvalidElementException if the accountNumber is less than or equal to zero.
     */
    public static void isValidAccountNumber(int accountNumber) throws InvalidElementException {
        if (accountNumber <= 0) {
            throw new InvalidElementException("BankBranch less than or equal to zero");
        } 
    }
}
