package com.natallia.jobtrack_api.exception;

public class InvalidSalaryRangeException extends RuntimeException {
    public InvalidSalaryRangeException(String message) {
        super(message);
    }
}
