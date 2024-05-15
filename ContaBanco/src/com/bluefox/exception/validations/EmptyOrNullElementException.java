package com.bluefox.exception.validations;

public class EmptyOrNullElementException extends Exception {
    public EmptyOrNullElementException() {
        super("Empty or Null Element");
    }

    public EmptyOrNullElementException(String message) {
        super(message);
    }
}
