package com.AddressBook.demo.utility;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.AddressBook.demo.Exception.ErrorDetails;

@RestControllerAdvice
public class AddressExceptionHandler {
	
	//Handler that handles the exception raised because of invalid data that is received as method argument (DTO)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleValidationExceptions(MethodArgumentNotValidException ex) 
	{
		 ErrorDetails error = new ErrorDetails();
	     error.setHttpStatus(HttpStatus.BAD_REQUEST);
	     error.setMessage(ex.getBindingResult().getAllErrors()
	    		 		  	.stream().map(ObjectError::getDefaultMessage)//lambda equivalent -> x->x.getDefaultMessage()
	    		 		  	.collect(Collectors.joining(", ")));
	        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	//Handler that handles the exception raised because of invalid data that is received as 
		//URI parameter (path variables, request parameters)
		@ExceptionHandler(ConstraintViolationException.class)
		public ResponseEntity<ErrorDetails> handleConstraintValidationExceptions(ConstraintViolationException ex) 
		{
			 ErrorDetails error = new ErrorDetails();
		     error.setHttpStatus(HttpStatus.BAD_REQUEST);
		     error.setMessage(ex.getConstraintViolations()
		    		 			.stream().map(ConstraintViolation::getMessage)//lambda equivalent -> x->x.getMessage()
		    		 			.collect(Collectors.joining(", ")));
		     return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		
		
}
