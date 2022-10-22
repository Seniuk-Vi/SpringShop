package com.epam.springshop.exceptions.validator;

import com.epam.springshop.model.enums.LocaleEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocaleValidator implements ConstraintValidator<LocaleConstraint,String > {
    @Override
    public void initialize(LocaleConstraint localeConstraint) {
        ConstraintValidator.super.initialize(localeConstraint);
    }

    @Override
    public boolean isValid(String locale, ConstraintValidatorContext constraintValidatorContext) {
        for (LocaleEnum status : LocaleEnum.values()) {
            if (status.name().equals(locale)) {
                return true;
            }
        }
        return false;
    }
}
