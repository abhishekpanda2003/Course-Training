package com.example.Library.Exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) {
        super(message);
    }
}
