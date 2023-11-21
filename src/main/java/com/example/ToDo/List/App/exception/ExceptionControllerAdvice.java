package com.example.ToDo.List.App.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{
/**
 * Method for handling SQLException
 * @param ex
 * @param request
 * @return
 */
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ExceptionResponse> sqlException(Exception ex, final HttpServletRequest request){
		ExceptionResponse response = new ExceptionResponse();
		response.setResponseMessage(ex.getMessage());
		response.setRequestURL(request.getRequestURI());
		response.setHttpStatus(HttpStatus.BAD_REQUEST);
		response.setTimestamp(new Date());
		response.setStatus(response.getHttpStatus().value());
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
	
	/**
	 * Method for handling ResourceNotFoundException
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFoundException(Exception ex, final HttpServletRequest request){
		ExceptionResponse response = new ExceptionResponse();
		response.setResponseMessage(ex.getMessage());
		response.setRequestURL(request.getRequestURI());
		response.setHttpStatus(HttpStatus.NOT_FOUND);
		response.setTimestamp(new Date());
		response.setStatus(response.getHttpStatus().value());
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
}
