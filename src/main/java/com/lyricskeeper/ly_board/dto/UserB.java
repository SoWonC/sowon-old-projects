package com.lyricskeeper.ly_board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserB {

	private int user_no;
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private LocalDateTime registerDateTime;

//	public boolean matchPassword(String password) {
//		return this.password.equals(password);
//	}
	
}
