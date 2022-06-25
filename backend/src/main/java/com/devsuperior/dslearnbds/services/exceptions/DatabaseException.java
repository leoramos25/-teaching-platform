package com.devsuperior.dslearnbds.services.exceptions;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionUID = 478607257509895061L;
    
    public DatabaseException(String message) {
        super(message);
    }
}
