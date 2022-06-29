package com.devsuperior.dslearnbds.services.exceptions;

public class UnauthorizedException extends RuntimeException {
    private static final long serialVersionUID = -1811572229200958448L;
    
    public UnauthorizedException(String message) {
        super(message);
    }
}
