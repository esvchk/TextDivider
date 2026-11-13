package com.innowise.course.exception;

public class TextException extends Exception {

    public TextException(String message, Throwable cause) {
        super(message, cause);
    }

    public TextException(String message) {
        super(message);
    }

    public TextException(Throwable cause) {
        super(cause);
    }
}
