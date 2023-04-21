package com.learn.timezone.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class TimeZoneExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	public ResponseEntity handleException(Exception e) {
		if (e instanceof HttpClientErrorException) {
			HttpClientErrorException httpClientErrorException = (HttpClientErrorException) e;
			if (httpClientErrorException.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
				return ResponseEntity.badRequest().body(buildErrorMessage(httpClientErrorException.getRawStatusCode(), httpClientErrorException.getMessage()));
			}
			if (httpClientErrorException.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(buildErrorMessage(httpClientErrorException.getRawStatusCode(), httpClientErrorException.getMessage()));
			}
				return ResponseEntity.badRequest().body(buildErrorMessage(httpClientErrorException.getRawStatusCode(), httpClientErrorException.getMessage()));
		}
		return ResponseEntity.internalServerError().body(buildErrorMessage(e));
	}

	private ErrorMessage buildErrorMessage(Exception e) {
		return new ErrorMessage(e.getMessage(), Long.valueOf(-1));
	}

	private ErrorMessage buildErrorMessage(int errorCode, String message) {
		return new ErrorMessage(message, Long.valueOf(errorCode));
	}
}
