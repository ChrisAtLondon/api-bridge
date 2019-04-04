package com.chris.apibridge.controller;

public class RESTfulAPIErrorResponse {
    int status;
    String message;

    public RESTfulAPIErrorResponse(RESTfulAPIStatus code, String message) {
        this.status = code.toCode();
        this.message = message;
    }

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

}
