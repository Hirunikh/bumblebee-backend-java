package com.hiruni.bumblebee.config;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

class ApiErrorBody {
    private String message;

    public ApiErrorBody(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiError.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            ApiError error) {
        return buildResponseEntity(error.getMessage(), error.getHttpStatus());
    }

    private ResponseEntity<Object> buildResponseEntity(String apiErrorMessage, HttpStatus httpStatus) {
        return new ResponseEntity<>(new ApiErrorBody(apiErrorMessage), httpStatus);
    }
}
