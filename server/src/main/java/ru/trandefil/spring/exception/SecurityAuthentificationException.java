package ru.trandefil.spring.exception;

public class SecurityAuthentificationException extends RuntimeException {
    public SecurityAuthentificationException(String message) {
        super(message);
    }
}
