package com.lyricskeeper.user.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AuthInfo {
	private int user_no;
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private LocalDateTime registerDateTime;
	
	public AuthInfo(String id, String name, String nickname, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.phone = phone;
	}
	
	
	
	

}
