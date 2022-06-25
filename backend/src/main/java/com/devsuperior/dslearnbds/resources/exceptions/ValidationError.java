package com.devsuperior.dslearnbds.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = -8906445721410700014L;
    
    private List<FieldMessage> errors = new ArrayList<>();
    
    public List<FieldMessage> getErrors() {
        return errors;
    }
    
    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}
