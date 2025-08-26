package com.lyricskeeper.ly_board.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lyricskeeper.ly_board.dto.Ly_Board2;
import com.lyricskeeper.ly_board.dto.Ly_Board3;
import com.lyricskeeper.ly_board.dto.Ly_BoardDto;
import com.lyricskeeper.ly_board.exception.BoardNotFoundException;

@Repository
public class Ly_BoardDao {

	private JdbcTemplate jdbcTemplate;

	public Ly_BoardDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Ly_BoardDto> list() {
		String sql = "select * from ly_board order by ly_board_no desc";
		return this.jdbcTemplate.query(sql, (rs, n) -> {
			Ly_BoardDto ly_Board = Ly_BoardDto.builder().ly_board_no(rs.getInt("ly_board_no"))
					.ly_title(rs.getString("ly_title")).ly_content(rs.getString("ly_content"))
					.tag_name(rs.getString("tag_name")).ly_boardregdate(rs.getDate("ly_boardregdate"))
					.ly_hits(rs.getInt("ly_hits")).nickname(rs.getString("nickname")).id(rs.getString("id")).build();
			return ly_Board;
		});
	}

	public Ly_BoardDto view(int ly_board_no) {
		if (ly_board_no <= 0) {
			throw new BoardNotFoundException("해당 id의 게시글이 없습니다.");
		}
		String sql = "select * from ly_board where ly_board_no = ?";
		return this.jdbcTemplate.queryForObject(sql, (rs, n) -> {
			Ly_BoardDto ly_Board = Ly_BoardDto.builder().ly_board_no(rs.getInt("ly_board_no"))
					.ly_title(rs.getString("ly_title")).ly_content(rs.getString("ly_content"))
					.tag_name(rs.getString("tag_name")).ly_boardregdate(rs.getDate("ly_boardregdate"))
					.ly_hits(rs.getInt("ly_hits")).nickname(rs.getString("nickname")).id(rs.getString("id")).build();
			return ly_Board;
		}, ly_board_no);
	}

	public int write(Ly_Board3 ly_Board3) {
		String sql = "insert into ly_board(ly_title, ly_content, tag_name, ly_boardregdate, ly_hits, nickname, id) values(?,?,?,now(),0,?,?)";
		return this.jdbcTemplate.update(sql, ly_Board3.getLy_title(), ly_Board3.getLy_content(), ly_Board3.getTag_name(),
				ly_Board3.getNickname(), ly_Board3.getId());
	}

	public int delete(int ly_board_no) {
		String sql = "delete from ly_board where ly_board_no = ?";
		return this.jdbcTemplate.update(sql, ly_board_no);
	}

	public void update(Ly_Board2 ly_Board2) {
		jdbcTemplate.update("update ly_board set ly_title = ?, ly_content = ?, tag_name = ? where ly_board_no = ?",
				ly_Board2.getLy_title(), ly_Board2.getLy_content(), ly_Board2.getTag_name() , ly_Board2.getLy_board_no());
	}
	
	public void ly_hitsUp(int ly_board_no) {
		jdbcTemplate.update("update ly_board set ly_hits = ly_hits + 1 where ly_board_no = ?",
				ly_board_no);
	}
}
