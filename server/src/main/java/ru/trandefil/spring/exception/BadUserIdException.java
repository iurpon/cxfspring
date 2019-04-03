package ru.trandefil.spring.exception;

public class BadUserIdException extends RuntimeException {
    public BadUserIdException(String message) {
        super(message);
    }
}
