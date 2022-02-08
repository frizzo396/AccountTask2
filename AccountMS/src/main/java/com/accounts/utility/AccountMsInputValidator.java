package com.accounts.utility;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import com.accounts.exception.AccountException;
import com.accounts.request.OpenAccountRequest;

public class AccountMsInputValidator {
	
	/**
	 * Validation of /openAccount request
	 * @param request
	 */
	public static void validateInput(OpenAccountRequest request) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<OpenAccountRequest>> violations = validator.validate(request);		
		violations.stream().findFirst().ifPresent(a -> {throw new AccountException(a.getMessage());});				
	}
}
