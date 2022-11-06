package com.epam.springshop.exceptions;

import com.epam.springshop.model.enums.ErrorType;

public class StatusNotFoundException extends NotFoundException{
    private static final String DEFAULT_MESSAGE="Status is not found";

    public StatusNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
