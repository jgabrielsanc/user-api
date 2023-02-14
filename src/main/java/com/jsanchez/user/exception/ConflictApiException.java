package com.jsanchez.user.exception;

public class ConflictApiException extends RuntimeException{

    public ConflictApiException(String message) {
        super(message);
    }
}
