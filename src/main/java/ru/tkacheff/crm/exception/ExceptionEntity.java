package ru.tkacheff.crm.exception;

import org.springframework.http.HttpStatus;

public record ExceptionEntity(int statusCode,
                              String message) {

}
