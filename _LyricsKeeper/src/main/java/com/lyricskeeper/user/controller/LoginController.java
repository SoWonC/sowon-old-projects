package com.lyricskeeper.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lyricskeeper.user.dto.AuthInfo;
import com.lyricskeeper.user.dto.LoginCommand;
import com.lyricskeeper.user.exception.WrongIdPasswordException;
import com.lyricskeeper.user.service.AuthService;
import com.lyricskeeper.user.validator.LoginCommandValidator;



@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private AuthService authService;
	
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping
	public String form(LoginCommand loginCommand,@CookieValue(value = "REMEMBER", required = false)Cookie rCookie) {
		if(rCookie != null) {
			loginCommand.setId(rCookie.getValue());
			loginCommand.setRememberId(true);
		}
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(@ModelAttribute  LoginCommand loginCommand, Errors errors,
			HttpSession httpSession, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if(errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getPassword());
			
			httpSession.setAttribute("authInfo", authInfo);
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getId());
			rememberCookie.setPath("/");
			if(loginCommand.isRememberId()) {
				rememberCookie.setMaxAge(60*60*24*30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);
			return "login/loginSuccess";
		} catch (WrongIdPasswordException e) {
			errors.reject("isPasswordNotMatching");
					return "login/loginForm";
		}
	}
	
	

}
