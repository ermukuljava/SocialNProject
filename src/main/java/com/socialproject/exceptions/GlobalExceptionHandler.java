package com.socialproject.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SocialPostNotFound.class)
    public ResponseEntity<?> handleSocialPostNotFoundException(SocialPostNotFound socialPostNotFound){

        HashMap<String, Object> exceptionBody = new HashMap<>();
        exceptionBody.put("time_stamp", LocalDateTime.now());
        exceptionBody.put("message", socialPostNotFound.getMessage());
        return new ResponseEntity<>(exceptionBody, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalException(Exception ex){

        HashMap<String, Object> globalExceptionBody = new HashMap<>();
        globalExceptionBody.put("time_stamp", LocalDateTime.now());
        globalExceptionBody.put("message", "Internal_Server_Error");

        return new ResponseEntity<>(globalExceptionBody, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
