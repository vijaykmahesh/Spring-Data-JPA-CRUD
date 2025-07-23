package com.boot.jpamain.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PANValidator  implements ConstraintValidator<ValidPAN, String> {

    private static final String PAN_PATTERN = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && value.matches(PAN_PATTERN);
	}
}