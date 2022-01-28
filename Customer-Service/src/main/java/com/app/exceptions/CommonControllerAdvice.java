package com.app.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.pojos.Response;

@ControllerAdvice
public class CommonControllerAdvice extends ResponseEntityExceptionHandler {
	
	
	public ResponseEntity<Map<String,String>> handleValidationExceptions( MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach( error -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return new ResponseEntity<>(errors, status); 
	} 
	/*
	@Override     
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {         
		List<String> validationList = ex.getBindingResult()
				                        .getFieldErrors()
				                        .stream()
				                        .map(fieldError -> fieldError.getDefaultMessage())
				                        .collect(Collectors.toList());         
		return new ResponseEntity<>(validationList, status);    
	}

	 */
	
}
