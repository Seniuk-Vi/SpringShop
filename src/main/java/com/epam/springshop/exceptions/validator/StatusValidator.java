package com.epam.springshop.exceptions.validator;

import com.epam.springshop.model.enums.StatusEnum;
import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StatusValidator implements ConstraintValidator<StatusConstraint, String> {

    private String field;

    public void initialize(StatusConstraint statusConstraint) {
        this.field = statusConstraint.field();
    }

    public boolean isValid(String value,
                           ConstraintValidatorContext context) {

        String fieldValue = (String) new BeanWrapperImpl(value)
                .getPropertyValue(field);
        for (StatusEnum status : StatusEnum.values()) {
            if (status.name().equals(fieldValue)) {
                return true;
            }
        }
        return false;
    }
}
