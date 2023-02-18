package com.epam.springshop.exceptions.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PatternValidator implements ConstraintValidator<PatternConstraint, String> {
    private String pattern;

    @Override
    public void initialize(PatternConstraint constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String field, ConstraintValidatorContext constraintValidatorContext) {
        return field != null && field.matches(pattern);
    }
}
