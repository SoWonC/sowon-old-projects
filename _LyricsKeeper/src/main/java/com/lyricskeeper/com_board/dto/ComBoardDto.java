package com.lyricskeeper.com_board.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class ComBoardDto {
	private int number;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	private String boardregdate;
	private int hits;
	private String nickname;

}
