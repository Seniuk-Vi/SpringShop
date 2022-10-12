package com.epam.springshop.controller;

import com.epam.springshop.exceptions.ServiceException;
import com.epam.springshop.model.Error;
import com.epam.springshop.model.enums.ErrorType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleServiceException(ServiceException ex, HandlerMethod hm){
        log.error("handleServiceException: message: {}, method: {}",ex.getMessage(),hm.getMethod().getName(),ex);
        return new Error(ex.getMessage(),ex.getErrorType(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handleException(ServiceException ex, HandlerMethod hm){
        log.error("handleServiceException: message: {}, method: {}",ex.getMessage(),hm.getMethod().getName(),ex);
        return new Error(ex.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
    }
}
