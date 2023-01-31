package com.gwabs.spring_example.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
    private final int status;
    private String message;
    private final String location;

    public ErrorDetails(int status, String message, String location) {
        this.status = status;
        this.message = message;
        this.location = location;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getLocation() {
        return location;
    }
}
