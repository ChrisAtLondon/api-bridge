package com.chris.apibridge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class RESTfulExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(RESTfulExceptionHandler.class);

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RESTfulAPIErrorResponse handle(ConstraintViolationException e) {
        return new RESTfulAPIErrorResponse(RESTfulAPIStatus.INVALID_ARGUMENT, e.getMessage());
    }

    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RESTfulAPIErrorResponse handle(Throwable t) {
        return new RESTfulAPIErrorResponse(RESTfulAPIStatus.INTERNAL, t.getMessage());
    }
}
