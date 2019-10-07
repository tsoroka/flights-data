package com.chartermatch.flightservices.controller;

import com.chartermatch.flightservices.to.ErrorResponseTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionController.class);

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponseTo handleException(Exception e) {
        LOGGER.error(e.getMessage(), e);

        ErrorResponseTo errorResponseTo = new ErrorResponseTo();
        errorResponseTo.setErrorMessage(e.getMessage());
        return errorResponseTo;
    }
}
