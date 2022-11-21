package com.airbrb.controller;

public class Result {
    private Object data;
    private String msg;

    public Result(Object data,String msg) {
        this.data = data;
        this.msg = msg;
    }

    public Result(Object data) {
        this.data = data;
    }

    public Result(String msg) {
        this.msg = msg;
    }

    public Result() {
    }

    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

}
