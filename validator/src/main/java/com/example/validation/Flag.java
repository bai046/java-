package com.example.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = FlagValidator.class)
public @interface Flag {
	String[] value() default {};

	String message() default "flag is not found";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}