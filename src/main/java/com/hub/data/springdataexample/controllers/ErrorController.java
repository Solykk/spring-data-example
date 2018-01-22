package com.hub.data.springdataexample.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class ErrorController implements org.springframework.boot.autoconfigure.web.ErrorController {

    private final static String PATH = "/error";

    @GetMapping(value = PATH)
    public ResponseEntity<?> error(){
        return ResponseEntity.ok("Error!!!");
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
