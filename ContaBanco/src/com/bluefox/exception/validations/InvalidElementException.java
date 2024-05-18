package com.bluefox.exception.validations;

public class InvalidElementException extends Exception {
    public InvalidElementException() {
        super("Invalid Element");
    }

    public InvalidElementException(String message) {
        super(message);
    }
}
