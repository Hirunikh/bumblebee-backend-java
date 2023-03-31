package com.hiruni.bumblebee.config;

import org.springframework.http.HttpStatus;

public class ApiError extends RuntimeException {

    public HttpStatus httpStatus;

    public ApiError(String errorMessage) {
        super(errorMessage);
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public ApiError(String errorMessage, HttpStatus httpStatus) {
        super(errorMessage);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
