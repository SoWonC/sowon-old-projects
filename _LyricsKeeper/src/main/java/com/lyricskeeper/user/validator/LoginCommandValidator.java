package com.lyricskeeper.user.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lyricskeeper.user.dto.LoginCommand;

public class LoginCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return LoginCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LoginCommand user =(LoginCommand) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		 if (!user.getPassword().equals(user.getPassword())) {
	            errors.rejectValue("password", "password.mismatch", "비밀번호가 일치하지 않습니다.");
	        }
	}

}
