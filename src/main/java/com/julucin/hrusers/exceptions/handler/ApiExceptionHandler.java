package com.julucin.hrusers.exceptions.handler;

import com.julucin.hrusers.exceptions.InstanceDoesNotExistException;
import com.julucin.hrusers.exceptions.NullIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = InstanceDoesNotExistException.class)
    public ResponseEntity<ExceptionHandlerResponse> handle(InstanceDoesNotExistException exception){
        return ResponseEntity.status(404).body(ExceptionHandlerResponse.of(exception));
    }

    @ExceptionHandler(value = NullIdException.class)
    public ResponseEntity<ExceptionHandlerResponse> handle(NullIdException exception){
        return ResponseEntity.status(400).body(ExceptionHandlerResponse.of(exception));
    }

}
