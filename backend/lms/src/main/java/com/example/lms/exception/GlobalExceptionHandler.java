package com.example.lms.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<String> handleStudentNotFoundException(StudentNotFoundException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
