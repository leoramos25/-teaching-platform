package com.devsuperior.dslearnbds.resources.exceptions.handlers;

import com.devsuperior.dslearnbds.resources.exceptions.OAuthCustomError;
import com.devsuperior.dslearnbds.resources.exceptions.StandardError;
import com.devsuperior.dslearnbds.resources.exceptions.ValidationError;
import com.devsuperior.dslearnbds.services.exceptions.DatabaseException;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
        var status = HttpStatus.NOT_FOUND;
        var error = new StandardError();
        
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Resource not found");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        
        return ResponseEntity.status(status).body(error);
    }
    
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseIntegrationViolation(DatabaseException exception, HttpServletRequest request) {
        var status = HttpStatus.BAD_REQUEST;
        var error = new StandardError();
        
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Database violation error");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        
        return ResponseEntity.status(status).body(error);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> argumentValidation(MethodArgumentNotValidException exception, HttpServletRequest request) {
        var status = HttpStatus.UNPROCESSABLE_ENTITY;
        var error = new ValidationError();
        
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Validation exception");
        error.setMessage(exception.getMessage());
        error.setPath(request.getRequestURI());
        
        for (FieldError f : exception.getBindingResult().getFieldErrors()) {
            error.addError(f.getField(), f.getDefaultMessage());
        }
        
        return ResponseEntity.status(status).body(error);
    }
    
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException exception) {
        var status = HttpStatus.FORBIDDEN;
        var error = new OAuthCustomError();
        
        error.setError("Forbidden");
        error.setErrorDescription(exception.getMessage());
        
        return ResponseEntity.status(status).body(error);
    }
    
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException exception) {
        var status = HttpStatus.UNAUTHORIZED;
        var error = new OAuthCustomError();
        
        error.setError("Unauthorized");
        error.setErrorDescription(exception.getMessage());
        
        return ResponseEntity.status(status).body(error);
    }
}
