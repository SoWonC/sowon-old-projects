package com.lyricskeeper.ly_board.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lyricskeeper.ly_board.dto.ThemaDto;

@Repository
public class ThemaDao {

private JdbcTemplate jdbcTemplate;
	
	public ThemaDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<ThemaDto> list() {
		String sql = "select * from thema order by tag_no";
		return this.jdbcTemplate.query(sql, (rs, n)->{
			ThemaDto themaDto = ThemaDto.builder().tag_no(rs.getInt("tag_no"))
					         .tag_name(rs.getString("tag_name"))
					         .build();
			return themaDto;
		});
	}
}
