package com.bluefox.exception.account;

public class InsufficientBankBalanceException extends Exception {
    public InsufficientBankBalanceException() {
        super("Insufficient Bank Balance for operation");
    }

    public InsufficientBankBalanceException(String message) {
        super(message);
    }
}
