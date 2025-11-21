package com.example.Library.Exception;

public class ResourceAlreadyExists extends RuntimeException {
    public ResourceAlreadyExists(String message) {
        super(message);
    }
}
