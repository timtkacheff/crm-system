package ru.tkacheff.crm.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tkacheff.crm.exception.AppointmentNotFoundException;
import ru.tkacheff.crm.exception.ExceptionEntity;
import ru.tkacheff.crm.exception.FinishedStatusChangeException;
import ru.tkacheff.crm.exception.StatusNotFoundException;

@ControllerAdvice
public class AppointmentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handleNotFoundId(AppointmentNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionEntity response =
                new ExceptionEntity(status.value(), exception.getLocalizedMessage());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handleNotFoundStatus(StatusNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionEntity response =
                new ExceptionEntity(status.value(), exception.getLocalizedMessage());

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handleStatusChange(FinishedStatusChangeException exception) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionEntity response =
                new ExceptionEntity(status.value(), exception.getLocalizedMessage());

        return new ResponseEntity<>(response, status);
    }
}
