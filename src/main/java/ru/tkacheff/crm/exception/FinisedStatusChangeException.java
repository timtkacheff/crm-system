package ru.tkacheff.crm.exception;

public class FinisedStatusChangeException extends RuntimeException {

    public FinisedStatusChangeException(String message) {
        super(message);
    }
}
