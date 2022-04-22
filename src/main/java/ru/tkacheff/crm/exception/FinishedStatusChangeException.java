package ru.tkacheff.crm.exception;

public class FinishedStatusChangeException extends RuntimeException {

    public FinishedStatusChangeException(String message) {
        super(message);
    }
}
