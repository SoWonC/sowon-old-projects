package com.lyricskeeper.ly_board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Ly_Board3 {			// insert 위한 dto

	private String ly_title;
	private String tag_name;
	private String ly_content;
	private String nickname;
	private String id;
	
	
}
