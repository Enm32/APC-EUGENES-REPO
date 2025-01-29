package com.example.progresscheckerforcbc.model;

public class signUpresponse {
    public signUpresponse() {
    }

    public signUpresponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
}
