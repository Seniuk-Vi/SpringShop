package com.epam.springshop.exceptions;

import com.epam.springshop.model.enums.ErrorType;

public class EntityIllegalArgumentException extends RuntimeException {
    private ErrorType errorType;

    public EntityIllegalArgumentException(String message) {
        super(message);
    }

    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }

    @Override
    public String toString() {
        return "EntityIllegalArgumentException{" +
                "message=" + super.getMessage() +
                '}';
    }
}
