package com.andrew.exception;

public class NoCommandException extends Exception {
    public NoCommandException() {}

    public NoCommandException(String message) {
        super(message);
    }

    public NoCommandException(String message, Throwable cause) {
        super(message, cause);
    }
}