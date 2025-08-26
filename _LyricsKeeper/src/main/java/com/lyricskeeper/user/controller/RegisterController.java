package com.lyricskeeper.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyricskeeper.user.dto.RegisterRequest;
import com.lyricskeeper.user.exception.DuplicateUserException;
import com.lyricskeeper.user.service.UserRegisterService;
import com.lyricskeeper.user.validator.RegisterRequestValidator;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RegisterController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	
	
//	public void setUserRegisterService(UserRegisterService userRegisterService) {
//		this.userRegisterService = userRegisterService;
//	}
//	


	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/register/step2")
	public String handleStep2(@Valid
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/register/step3")
	public String handleStep3(@Valid RegisterRequest regReq, Errors errors) {
		new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors())
			return "register/step2";
		if (errors.hasErrors() || regReq.getId().length() < 4) {
	        if (regReq.getId().length() < 4) {
	            errors.rejectValue("id", "Size");
	        }
	        return "register/step2"; // 유효성 검사 오류가 있거나 아이디 길이가 4글자 미만인 경우, 두 번째 단계로 다시 이동
	    }
		if (errors.hasErrors() || regReq.getPassword().length() < 4) {
	        if (regReq.getPassword().length() < 4) {
	            errors.rejectValue("password", "Size");
	        }
	        return "register/step2"; // 유효성 검사 오류가 있거나 비밀번호 길이가 4글자 미만인 경우, 두 번째 단계로 다시 이동
	    }
		if (errors.hasErrors() || regReq.getId().length() < 4) {
	        if (regReq.getId().length() < 4) {
	            errors.rejectValue("confirmPassword", "Size");
	        }
	        return "register/step2"; // 유효성 검사 오류가 있거나 확인 비밀번호 길이가 4글자 미만인 경우, 두 번째 단계로 다시 이동
	    }
		try {
			userRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateUserException ex) {
			errors.rejectValue("id", "duplicate");
			return "register/step2";//아이디 중복 에러가 발생한 경우, 두 번째 단계로 다시 이동
		} 
		
		
	}
	

}
