package com.epam.springshop.exceptions.impl;

import com.epam.springshop.exceptions.NotFoundException;
import com.epam.springshop.model.enums.ErrorType;

public class OrderItemNotFoundException extends NotFoundException {
    private static final String DEFAULT_MESSAGE="Order item is not found";

    public OrderItemNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
