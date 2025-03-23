package com.example.fd.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        exception.getMessage(),
                        webRequest.getDescription(false),
                        "USER_NOT_FOUND"
                ), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        exception.getMessage(),
                        webRequest.getDescription(false),
                        "USER_EMAIL_ALREADY_EXISTS"
                ), HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception, WebRequest webRequest){
        return new ResponseEntity<>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        exception.getMessage(),
                        webRequest.getDescription(false),
                        "INTERNAL_SERVER_ERROR"
                ), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


}
