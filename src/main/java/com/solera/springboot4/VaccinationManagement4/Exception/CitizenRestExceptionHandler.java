package com.solera.springboot4.VaccinationManagement4.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CitizenRestExceptionHandler 
{
	@ExceptionHandler
	public ResponseEntity<CitizenErrorResponse> handleException(CitizenNotFoundException c)
	{
		CitizenErrorResponse error = new CitizenErrorResponse(HttpStatus.NOT_FOUND.value(),
																c.getMessage(),
																System.currentTimeMillis());
		
		return new ResponseEntity<CitizenErrorResponse>(error,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CitizenErrorResponse> handleException(Exception e)
	{
		CitizenErrorResponse error = new CitizenErrorResponse(HttpStatus.NOT_FOUND.value(),
																e.getMessage(),
																System.currentTimeMillis());

		return new ResponseEntity<CitizenErrorResponse>(error,HttpStatus.BAD_REQUEST);
		
	}

}
