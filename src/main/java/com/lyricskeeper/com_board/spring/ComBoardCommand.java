package com.lyricskeeper.com_board.spring;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ComBoardCommand {

	private int id;
	private String title;
	private String content;
	private LocalDate boardregdate;
	private String hits;
	private String nickname;

}
