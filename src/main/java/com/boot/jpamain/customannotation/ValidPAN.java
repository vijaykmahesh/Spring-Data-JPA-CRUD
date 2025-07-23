package com.boot.jpamain.customannotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = PANValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPAN {

	String message() default "Invalid PAN number. Expected format: 5 letters, 4 digits, 1 letter (e.g. ABCDE1234F)";

	// 🔥 These two are mandatory as per Bean Validation spec
	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
