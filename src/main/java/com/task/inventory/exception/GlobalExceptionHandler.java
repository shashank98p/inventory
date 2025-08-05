package com.task.inventory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleItemNotFound(ItemNotFoundException ex){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("status",HttpStatus.NOT_FOUND.value());
        errorBody.put("message",ex.getMessage());
        return new ResponseEntity<>(errorBody, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String,Object>> handleAllException(Exception ex){
        Map<String,Object> errorBody = new HashMap<>();
        errorBody.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorBody.put("message","Internal Server Error");
        return new ResponseEntity<>(errorBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
