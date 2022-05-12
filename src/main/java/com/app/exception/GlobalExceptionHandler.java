package com.app.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.ApplicationResponseDTO;
import com.app.dto.ErrorResponse;


// Custom Exception :  https://examples.javacodegeeks.com/spring-boot-bean-validation-example/#:~:text=The%20Bean%20Validation%20API%20is,built%2Din%20constraints%20are%20inadequate.

// @RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String,String> errors = new HashMap<String,String>();
		
		List<ObjectError> ObjErrors = ex.getBindingResult().getAllErrors();
		for (ObjectError error : ObjErrors) {
			errors.put(((FieldError)error).getField() , error.getDefaultMessage());
		}
		
		
		 ApplicationResponseDTO appResponse = new ApplicationResponseDTO();
		    
		    ErrorResponse errorResponse = new ErrorResponse();
		    errorResponse.setErrrors(errors);
		    errorResponse.setErrorCode("400");
		    errorResponse.setErrorDesc("invalid inputs.");
		    
		    appResponse.setErrorDetails(errorResponse);
		    
		    return new ResponseEntity<Object>(appResponse,HttpStatus.BAD_REQUEST);
		
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<ApplicationResponseDTO> handleConstraintViolation( ConstraintViolationException ex, WebRequest request) {
	    List<String> errors = new ArrayList<String>();
	    
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	        errors.add(violation.getMessage());
	    }

	    ApplicationResponseDTO appResponse = new ApplicationResponseDTO();
	    
	    ErrorResponse errorResponse = new ErrorResponse();
	    errorResponse.setErrrors(errors);
	    errorResponse.setErrorCode("400");
	    errorResponse.setErrorDesc("invalid inputs.");
	    
	    appResponse.setErrorDetails(errorResponse);
	    
	    return new ResponseEntity<ApplicationResponseDTO>(appResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RecordNotFound.class)
	public ResponseEntity<String> handleRecordNotFoundException(RecordNotFound ex){
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
	
}
