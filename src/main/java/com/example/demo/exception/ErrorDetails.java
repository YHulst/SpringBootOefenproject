package com.example.demo.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private HttpStatus status;
    private String debugMessage;


    public ErrorDetails(String message, String details){
        super();
        this.setTimestamp(LocalDateTime.now());
        this.setMessage(message);
        this.setDetails(details);
    }

    public ErrorDetails(HttpStatus status, Throwable ex) {
        super();
        this.setTimestamp(LocalDateTime.now());
        this.setStatus(status);
        this.message = "Unexpected error";
        this.setDebugMessage(ex.getLocalizedMessage());
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }
}
