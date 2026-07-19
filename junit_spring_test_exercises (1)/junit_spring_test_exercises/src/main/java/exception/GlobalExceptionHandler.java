package com.example.junit_spring_test_exercises.exception;

import java.util.NoSuchElementException;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNotFound(NoSuchElementException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User not found");

    }

}