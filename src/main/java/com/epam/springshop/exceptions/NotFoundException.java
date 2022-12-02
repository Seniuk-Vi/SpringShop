package com.epam.springshop.exceptions;

import com.epam.springshop.model.enums.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class NotFoundException extends RuntimeException {
    private ErrorType errorType;

    public NotFoundException(String message) {
        super(message);
    }

    public ErrorType getErrorType() {
        return ErrorType.FATAL_ERROR_TYPE;
    }
}
