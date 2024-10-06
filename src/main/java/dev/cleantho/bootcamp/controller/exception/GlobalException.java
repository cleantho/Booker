package dev.cleantho.bootcamp.controller.exception;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	private final Logger logger = LoggerFactory.getLogger(GlobalException.class);

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handlerIllegalArgument(IllegalArgumentException IllegalArgument) {		
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(IllegalArgument.getMessage());
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handlerNoSuchElement(NoSuchElementException noSuchElement) {		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource ID not found.");
	}
	
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> handlerUnexpectedException(Throwable unexpectedException) {
		String msn = "Unexpected server error, see the logs.";
		logger.error(msn, unexpectedException);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(msn);
	}
}
