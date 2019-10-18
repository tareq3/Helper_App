package com.mti.helper.utils;

public class ResponseFormat {
    public String error;
    public Object result;

    public ResponseFormat(String error, Object result) {
        this.error = error;
        this.result = result;
    }

    
}
