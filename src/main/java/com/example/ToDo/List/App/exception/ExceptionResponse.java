package com.example.ToDo.List.App.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;
/**
 * Custom Exception Response class
 * @author Aravind
 *
 */
@Data
public class ExceptionResponse {
	
	private Date timestamp;
	private int status;
	private HttpStatus httpStatus;
	private String responseMessage;
	private String requestURL;

}
