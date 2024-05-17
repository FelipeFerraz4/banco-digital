package com.bluefox.utils;

public enum Rate {
    SELIC(0.105), // taxa
    REFERENCE_RATE(0.0007);

    private final double value;

    Rate(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

}
