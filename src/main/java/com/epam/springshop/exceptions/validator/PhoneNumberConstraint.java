package com.epam.springshop.exceptions.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumberConstraint {
    String message()default "Phone number must have 10 digits";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload()default {};
}
