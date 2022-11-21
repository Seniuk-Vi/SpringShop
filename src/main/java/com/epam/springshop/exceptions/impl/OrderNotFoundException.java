package com.epam.springshop.exceptions.impl;

import com.epam.springshop.exceptions.NotFoundException;
import com.epam.springshop.model.enums.ErrorType;

public class OrderNotFoundException extends NotFoundException {
    private static final String DEFAULT_MESSAGE="Order is not found";

    public OrderNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}