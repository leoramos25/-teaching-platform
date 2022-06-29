package com.devsuperior.dslearnbds.services.exceptions;

public class ForbiddenException extends RuntimeException {
    private static final long serialVersionUID = 2250037521939357964L;
    
    public ForbiddenException(String message) {
        super(message);
    }
}
