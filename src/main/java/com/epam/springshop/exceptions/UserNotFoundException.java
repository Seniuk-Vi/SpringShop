package com.epam.springshop.exceptions;

import com.epam.springshop.model.enums.ErrorType;

public class UserNotFoundException extends NotFoundException{
    private static final String DEFAULT_MESSAGE="User is not found";

    public UserNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
