package com.example.progresscheckerforcbc.model;

public class tokenresponse {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public tokenresponse() {
    }

    public tokenresponse(int statusCode, String token) {
        this.statusCode = statusCode;
        this.token = token;
    }

    private int statusCode;
    private String token;
}
