package com.ground.util;

public class UsageAlreadyExistsException extends Exception {

    public UsageAlreadyExistsException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
