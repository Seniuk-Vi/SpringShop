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
        System.out.println("locale: "+locale);
        for (LocaleEnum status : LocaleEnum.values()) {
            System.out.println(status.name());
            if (status.name().equals(locale)) {
                return true;
            }
        }
        return false;
    }
}
