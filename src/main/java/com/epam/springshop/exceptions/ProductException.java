package com.epam.springshop.exceptions;

import com.epam.springshop.model.enums.ErrorType;

public class ProductException extends ServiceException{
    private static final String DEFAULT_MESSAGE="Wrong product fields";

    public ProductException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
