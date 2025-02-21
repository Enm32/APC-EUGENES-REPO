package com.example.progresscheckerforcbc.model;

public class NotificationResponse {
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotificationResponse() {
    }

    public NotificationResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;
}
