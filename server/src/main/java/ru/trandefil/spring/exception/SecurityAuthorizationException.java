package ru.trandefil.spring.exception;

public class SecurityAuthorizationException extends RuntimeException {
    public SecurityAuthorizationException(String message) {
        super(message);
    }
}
