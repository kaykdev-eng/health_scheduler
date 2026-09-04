package com.kayk.healthscheduler.service.exception;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Could not find the resource with the ID: " + id);
    }
}
