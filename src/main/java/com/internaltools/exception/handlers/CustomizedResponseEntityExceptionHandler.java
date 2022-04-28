package com.internaltools.exception.handlers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.internaltools.exception.AppException;
import com.internaltools.exception.ExpiredTokenException;
import com.internaltools.exception.InvalidTokenException;
import com.internaltools.exception.ResourceNotFoundException;
import com.internaltools.payload.response.ExceptionResponse;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), Boolean.FALSE);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AppException.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions(AppException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), Boolean.FALSE);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException ex,
			WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), Boolean.FALSE);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidTokenException.class)
	public final ResponseEntity<Object> handleInvalidTokenException(InvalidTokenException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), Boolean.FALSE);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ExpiredTokenException.class)
	public final ResponseEntity<Object> handleExpiredTokenException(ExpiredTokenException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), Boolean.FALSE);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false), errors, Boolean.FALSE);
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}