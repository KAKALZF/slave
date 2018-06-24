package com.example.slave.Bean;

import java.io.Serializable;

public class ResponseBean<T> implements Serializable {
    Integer code;
    T data;
    String message;


    public Integer getCode() {
        return code;
    }

    public ResponseBean setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseBean setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseBean setMessage(String message) {
        this.message = message;
        return this;
    }
}
