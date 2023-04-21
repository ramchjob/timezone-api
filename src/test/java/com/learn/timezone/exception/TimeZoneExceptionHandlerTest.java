package com.learn.timezone.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

@ExtendWith(MockitoExtension.class)
public class TimeZoneExceptionHandlerTest {
	
	
	@Test
	public void testHttpClientNotFoundException() {
		TimeZoneExceptionHandler handler = new TimeZoneExceptionHandler();
		HttpClientErrorException ex = new HttpClientErrorException(HttpStatus.NOT_FOUND, null, "Test".getBytes(), Charset.defaultCharset());
		ResponseEntity errorMessage = handler.handleException(ex);
		assertNotNull(errorMessage);
		assertEquals(HttpStatus.NOT_FOUND, errorMessage.getStatusCode());
	}
	
	@Test
	public void testHttpClientBadRequestException() {
		TimeZoneExceptionHandler handler = new TimeZoneExceptionHandler();
		HttpClientErrorException ex = new HttpClientErrorException(HttpStatus.BAD_REQUEST, null, "Test".getBytes(), Charset.defaultCharset());
		ResponseEntity errorMessage = handler.handleException(ex);
		assertNotNull(errorMessage);
		assertEquals(HttpStatus.BAD_REQUEST, errorMessage.getStatusCode());
	}
	
	@Test
	public void testHttpClientBadGatewayException() {
		TimeZoneExceptionHandler handler = new TimeZoneExceptionHandler();
		HttpClientErrorException ex = new HttpClientErrorException(HttpStatus.BAD_GATEWAY, null, "Test".getBytes(), Charset.defaultCharset());
		ResponseEntity errorMessage = handler.handleException(ex);
		assertNotNull(errorMessage);
		assertEquals(HttpStatus.BAD_REQUEST, errorMessage.getStatusCode());
		assertNotNull(errorMessage.getBody());
		ErrorMessage message = (ErrorMessage) errorMessage.getBody();
		assertNotNull(message);
		assertEquals(502L, message.getErrorId());
		assertEquals("502 Bad Gateway", message.getMessage());
	}
	
	@Test
	public void testException() {
		TimeZoneExceptionHandler handler = new TimeZoneExceptionHandler();
		Exception ex = new Exception("Test");
		ResponseEntity<ErrorMessage> errorMessage = handler.handleException(ex);
		assertNotNull(errorMessage);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage.getStatusCode());
		assertNotNull(errorMessage.getBody());
		ErrorMessage message = (ErrorMessage) errorMessage.getBody();
		assertNotNull(message);
		assertEquals(-1, message.getErrorId());
		assertEquals("Test", message.getMessage());
	}

}
