package ru.testproject.voting.util.exception;

public class TimeLimitException extends RuntimeException{
    public TimeLimitException(String message) {
        super(message);
    }
}
