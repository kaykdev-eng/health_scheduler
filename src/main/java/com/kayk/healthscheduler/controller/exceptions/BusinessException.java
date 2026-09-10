package com.kayk.healthscheduler.controller.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {
    HttpStatus status;
    String code;
    public BusinessException(String message, HttpStatus status, String code) {
        super(message);
        this.status = status;
        this.code = code;
    }

    public BusinessException(String message) {
        this(message, HttpStatus.BAD_REQUEST, "BUSINESS_ERROR");
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }
}
