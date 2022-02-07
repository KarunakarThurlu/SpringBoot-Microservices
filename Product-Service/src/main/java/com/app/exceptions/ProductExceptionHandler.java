package com.app.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.constants.CommonConstants;
import com.app.pojos.Response;


@ControllerAdvice
public class ProductExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		Response<Object> apiError = new Response<>(HttpStatus.BAD_REQUEST,  errors,ex.getLocalizedMessage());
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	}

	
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
		String error = ex.getName() + " should be of type " + ex.getRequiredType().getName();
		Response<Object> apiError = new Response<>(HttpStatus.BAD_REQUEST,  error,ex.getLocalizedMessage());
		return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
	}

	@ExceptionHandler({ ProductException.class })
	public ResponseEntity<Object> handleProductExceptions(ProductException ex, WebRequest request) {
		return new ResponseEntity<>(Map.of("ErrorCode",ex.getErrorCode(), "Message",ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ NoSuchElementException.class })
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex, WebRequest request) {
		return new ResponseEntity<>(Map.of("ErrorCode",CommonConstants.PRODUCT_NOT_FOUND_ERR_CODE, "ErrorMessage",ex.getMessage()),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		
		Response<Object> apiError = new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), "error occurred");
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
	
}
