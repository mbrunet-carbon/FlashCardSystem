package com.flashcardsystem.domain.exception;

public class CardNotFoundException extends RuntimeException {

    public CardNotFoundException(String id) {
        super("Card with id " + id + " not found");
    }
}
