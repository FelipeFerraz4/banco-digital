package com.bluefox.exception.bank;

/**
 * EmptyCustomerBankException
 */

public class EmptyCustomerBankException extends Exception{
    public EmptyCustomerBankException() {
        super("Bank Customer Set is Empty");
    }

    public EmptyCustomerBankException(String message) {
        super(message);
    }
}