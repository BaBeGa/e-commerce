package com.th.ac.ku.kps.cpe.ecommerce.controller;

import com.th.ac.ku.kps.cpe.ecommerce.exception.ErrorDetails;
import com.th.ac.ku.kps.cpe.ecommerce.exception.TokenNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TokenNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(TokenNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(401,ex.getMessage());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }
}
