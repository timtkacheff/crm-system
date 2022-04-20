package ru.tkacheff.crm.exception;

import org.springframework.http.HttpStatus;

public record ExceptionEntity(HttpStatus status,
                              String message) {

}
