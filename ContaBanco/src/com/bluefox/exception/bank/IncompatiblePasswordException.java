package com.bluefox.exception.bank;

public class IncompatiblePasswordException extends Exception {
    public IncompatiblePasswordException() {
        super("Incompatible Password");
    }

    public IncompatiblePasswordException(String message) {
        super(message);
    }
}
