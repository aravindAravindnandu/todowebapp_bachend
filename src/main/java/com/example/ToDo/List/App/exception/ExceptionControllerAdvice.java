package com.example.ToDo.List.App.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {
	/**
	 * Method for handling SQLException
	 * 
	 * @param ex
	 * @param request
	 * @return
	 */
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<ExceptionResponse> sqlException(Exception ex, final HttpServletRequest request) {
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
	 * 
	 * @param ex
	 * @param requests
	 * @return
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> resourceNotFoundException(Exception ex, final HttpServletRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setResponseMessage(ex.getMessage());
		response.setRequestURL(request.getRequestURI());
		response.setHttpStatus(HttpStatus.NOT_FOUND);
		response.setTimestamp(new Date());
		response.setStatus(response.getHttpStatus().value());
		return new ResponseEntity<>(response, response.getHttpStatus());
	}
/**
 * Method for handling MethodArgumentNotValidException
 * 
 * @param ex
 * @param request
 * @return
 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
		List<String> errors = new ArrayList<>();

		ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

		Map<String, List<String>> result = new HashMap<>();
		result.put("errors", errors);

		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
