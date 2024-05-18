package com.bluefox.exception.account;

public class EmptySavingAccountException extends Exception {
    public EmptySavingAccountException() {
        super("Empty Saving Account");
    }

    public EmptySavingAccountException(String message) {
        super(message);
    }
}
