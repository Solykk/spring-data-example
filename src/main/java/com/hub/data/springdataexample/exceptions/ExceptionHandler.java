package com.hub.data.springdataexample.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Dmitriy Lyashenko
 */
@RestControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAll(Exception ex){
        ex.printStackTrace();
        return ResponseEntity.ok(ex.getMessage());
    }
}
