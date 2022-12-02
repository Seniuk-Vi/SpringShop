package com.epam.springshop.exceptions.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = LocaleValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LocaleConstraint {
    String message()default "Locale not found";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload()default {};
}
