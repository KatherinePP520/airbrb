package com.airbrb.controller;

public class Error {
    private String error;

    public Error(String err) {
        this.error = err;
    }

    public String getErr() {
        return error;
    }

    public void setErr(String err) {
        this.error = err;
    }
}
