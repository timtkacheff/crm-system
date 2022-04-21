package ru.tkacheff.crm.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tkacheff.crm.exception.ClientNotFoundException;
import ru.tkacheff.crm.exception.ExceptionEntity;

@ControllerAdvice
public class ClientExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handleNotFound(ClientNotFoundException exception) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionEntity response =
                new ExceptionEntity(status.value(), exception.getLocalizedMessage());

        return new ResponseEntity<>(response, status);
    }
}
