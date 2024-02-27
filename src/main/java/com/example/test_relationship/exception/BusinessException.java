package com.example.test_relationship.exception;

import com.example.test_relationship.common.api.StatusCode;

public class BusinessException extends RuntimeException{

    private final StatusCode errorCode;

    public BusinessException(String message, StatusCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BusinessException(StatusCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(Throwable e, StatusCode errorCode) {
        this(errorCode);
    }

    public StatusCode getErrorCode() {
        return errorCode;
    }

}
