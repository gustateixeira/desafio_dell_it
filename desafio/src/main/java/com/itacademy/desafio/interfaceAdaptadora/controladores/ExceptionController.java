package com.itacademy.desafio.interfaceAdaptadora.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        System.out.println(Arrays.toString(e.getStackTrace()));
        return new ResponseEntity<>("Aconteceu um erro:" + Arrays.toString(e.getStackTrace()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}