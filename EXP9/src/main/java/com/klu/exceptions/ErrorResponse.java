package com.klu.exceptions;

import java.time.LocalDate;

public class ErrorResponse {
	private LocalDate timestamp;
    private String message;
    private int statusCode;

    public ErrorResponse(LocalDate timestamp, String message, int statusCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.statusCode = statusCode;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

}
