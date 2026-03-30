package com.spider.__email_service.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class TestController {

    @GetMapping("/exc")
    public String exc() {
        int a = 10 / 0;
        return "hello";
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<String> handleArithmetic(ArithmeticException exception) {
        System.out.println("Arithmetic exception handled...");
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
