package com.flashcardsystem.domain.exception;

public class BoxNotFoundException extends RuntimeException {
    public BoxNotFoundException(int id) {
        super("Box with id " + id + " not found");
    }
}
