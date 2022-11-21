package com.airbrb.controller;

import com.airbrb.exception.AuthException;
import com.airbrb.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity doBusinessException(BusinessException ex){
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(APPLICATION_JSON)
                .body(new Error(ex.getMessage()));
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity doAuthException(AuthException ex){
        return  ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .contentType(APPLICATION_JSON)
                .body(new Error(ex.getMessage()));
    }
}
