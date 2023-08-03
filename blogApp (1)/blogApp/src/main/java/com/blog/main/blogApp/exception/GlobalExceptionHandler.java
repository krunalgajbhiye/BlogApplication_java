package com.blog.main.blogApp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> resourceNotFoundExceptionResponseHandler(ResourceNotFoundException rx){

        Map<String, String> errorMessage = new HashMap<>();
        errorMessage.put("Message",rx.getMessage()+" by id : " + rx.getValue());
        errorMessage.put("statusCode",rx.getStatusCode());

        // String error = rx.getMessage() + " : " + rx.getValue();
        return new ResponseEntity<Map<String,String>>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
