package ru.tkacheff.crm.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tkacheff.crm.exception.ExceptionEntity;
import ru.tkacheff.crm.exception.MasterNotFoundException;

@ControllerAdvice
public class MasterExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handleNotFound(MasterNotFoundException exception) {

        ExceptionEntity response =
                new ExceptionEntity(HttpStatus.NOT_FOUND, exception.getLocalizedMessage());

        return new ResponseEntity<>(response, response.status());
    }

}
