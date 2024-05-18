package com.bluefox.exception.account;

public class InvalidValue extends Exception{
    public InvalidValue() {
        super("Invalid Value");
    }

    public InvalidValue(String message) {
        super(message);
    }
}
