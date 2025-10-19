package com.example.usermanagement.exception;

// Custom exception to handle "not found" errors
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
