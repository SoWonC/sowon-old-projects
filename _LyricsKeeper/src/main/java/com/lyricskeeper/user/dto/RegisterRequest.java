package com.lyricskeeper.user.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
	@Size(min=4)
	private String id;
	@Size(min=4)
	private String password;
	@Size(min=4)
	private String confirmPassword;
	@Pattern(regexp = "^[가-힣]*$", message = "이름은 한글로만 입력해주세요.")
	private String name;
	private String phone;
	private String nickname;

	
	
	
	
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
}
