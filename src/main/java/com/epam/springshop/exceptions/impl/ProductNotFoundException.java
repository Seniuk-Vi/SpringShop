package com.epam.springshop.exceptions.impl;

import com.epam.springshop.exceptions.NotFoundException;
import com.epam.springshop.model.enums.ErrorType;

public class ProductNotFoundException extends NotFoundException {
    private static final String DEFAULT_MESSAGE="Product is not found";

    public ProductNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
