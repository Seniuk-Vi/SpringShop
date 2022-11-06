package com.epam.springshop.exceptions;

import com.epam.springshop.model.enums.ErrorType;

public class RoleNotFoundException extends NotFoundException{
    private static final String DEFAULT_MESSAGE="Role is not found";

    public RoleNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
