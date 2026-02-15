package com.example.exception;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(String name) {
        super("Location not found: " + name);
    }
}
