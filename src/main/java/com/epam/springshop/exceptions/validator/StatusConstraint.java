package com.epam.springshop.exceptions.validator;

import javax.validation.Constraint;
import java.lang.annotation.*;

@Constraint(validatedBy = StatusValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StatusConstraint {
    String message() default "Invalid order status";

    String field();


    @interface List {
        StatusConstraint[] value();
    }
}
