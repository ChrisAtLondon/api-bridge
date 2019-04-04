package com.chris.apibridge.controller;

public enum RESTfulAPIStatus {
    INTERNAL(1),
    INVALID_ARGUMENT(2);

    private int errorCode;

    RESTfulAPIStatus(int errorCode) {
        this.errorCode = errorCode;
    }

    public int toCode() {
        return errorCode;
    }
}
