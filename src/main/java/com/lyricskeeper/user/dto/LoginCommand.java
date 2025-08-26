package com.lyricskeeper.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginCommand {
	
	private String id;
	private String password;
	private boolean rememberId;
	
	public boolean isRememberId() {
		return rememberId;
	}
	
	public void setRememberId(boolean rememberId) {
		this.rememberId = rememberId;
	}
	
}
