package io.github.mikedgl.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import io.github.mikedgl.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
		StandardError standardError = new StandardError();
		standardError.setInstant(Instant.now());
		standardError.setStatus(404);
		standardError.setError("Resource not found");
		standardError.setMessager(e.getMessage());
		standardError.setPath(request.getRequestURI());
		return ResponseEntity.status(404).body(standardError); 
	}
}
