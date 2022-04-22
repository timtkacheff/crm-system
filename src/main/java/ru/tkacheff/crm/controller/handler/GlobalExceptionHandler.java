package ru.tkacheff.crm.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.tkacheff.crm.exception.ExceptionEntity;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<List<ExceptionEntity>> handleValidationViolation(MethodArgumentNotValidException exception) {
        List<ExceptionEntity> response = new ArrayList<>();

        HttpStatus status = HttpStatus.NOT_ACCEPTABLE;
        for (ObjectError error : exception.getAllErrors()) {
            response.add(new ExceptionEntity(status.value(), error.getDefaultMessage()));
        }

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionEntity> handleMissingParameter(MissingServletRequestParameterException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionEntity exceptionEntity = new ExceptionEntity(status.value(), e.getLocalizedMessage());

        return new ResponseEntity<>(exceptionEntity, status);
    }

}
