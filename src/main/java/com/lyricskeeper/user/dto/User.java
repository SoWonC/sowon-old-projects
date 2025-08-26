package com.lyricskeeper.user.dto;

import java.time.LocalDateTime;

import com.lyricskeeper.user.exception.WrongIdPasswordException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	private int user_no;
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private LocalDateTime registerDateTime;

	public User(String id, String password, String name, String nickname, String phone, LocalDateTime regdate) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
		this.registerDateTime = regdate;	
	}
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);}
}
