package com.wipro.nga.milestone2.exception;


public class InvalidSearchRequestException extends RuntimeException {

    private final ErrorCode errorCode;

    public InvalidSearchRequestException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}


