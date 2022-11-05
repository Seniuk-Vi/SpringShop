package com.epam.springshop.exceptions;

import com.epam.springshop.model.enums.ErrorType;

public class ProductNotFoundException extends ServiceException{
    private static final String DEFAULT_MESSAGE="Product is not found";

    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
