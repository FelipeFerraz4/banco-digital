package com.bluefox.exception.bank;

public class ElementNotFindException extends Exception {
    public ElementNotFindException() {
        super("Element Not Find");
    }

    public ElementNotFindException(String message) {
        super(message);
    }
}
