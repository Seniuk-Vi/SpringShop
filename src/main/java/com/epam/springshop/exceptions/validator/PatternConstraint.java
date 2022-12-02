package com.epam.springshop.exceptions.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PatternValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PatternConstraint {
    String message()default "Pattern doesn't match";
    String pattern();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload()default {};
}
