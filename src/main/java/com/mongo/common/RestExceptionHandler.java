package com.mongo.common;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Validated
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ErrorResponseException.class)
	public ResponseEntity<Response> handleEntityNotFound(ErrorResponseException ex) {
		
		return ResponseEntity
				.status(HttpStatus.valueOf(ex.getStatus().value()))
				.body(ex.getResponse());
	}
    
	
    public List<Error>  handle(ConstraintViolationException exception) {
        return exception.getConstraintViolations()
                .stream()
                .map(error -> new Error(error.getMessageTemplate(), error.getMessage()))
                .collect(Collectors.toList());
    }
	
    public List<Error>  handle(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors()
                .stream()
                .map(error -> new Error(":: Handle Exception :: ",error.getDefaultMessage()))
                .collect(Collectors.toList());
    }


}