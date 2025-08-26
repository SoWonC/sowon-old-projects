package com.lyricskeeper.ly_board.dto;
//ly_board_no int auto_increment primary key,
//ly_title varchar(100) not null,
//ly_content varchar(1000) not null,
//tag_name varchar(50) not null,
//ly_boardregdate datetime not null,
//ly_hits int,
//nickname varchar(50) not null

import java.util.Date;

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
public class Ly_BoardDto {		// 전체 dto 
	
	private int ly_board_no;
	private String ly_title;
	private String ly_content;
	private String tag_name;
	private Date ly_boardregdate;
	private int ly_hits;
	private String nickname;
	private String id;
}
