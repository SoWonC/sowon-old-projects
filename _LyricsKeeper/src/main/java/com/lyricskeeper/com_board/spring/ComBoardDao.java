package com.lyricskeeper.com_board.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lyricskeeper.com_board.dto.ComBoardDto;
import com.lyricskeeper.user.dto.User;

@Repository
public class ComBoardDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ComBoardDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private RowMapper<ComBoardDto> comRowMapper = new RowMapper<ComBoardDto>() {

		@Override
		public ComBoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			ComBoardDto boardDto = ComBoardDto.builder().number(rs.getInt("com_board_no"))
					.title(rs.getString("com_title")).content(rs.getString("com_content")).hits(rs.getInt("com_hits"))
					.nickname(rs.getString("nickname")).boardregdate(rs.getString("com_boardregdate")) // 날짜/시간 값 가져오기
					.build();
			boardDto.setNumber(rs.getInt("com_board_no"));
			return boardDto;
		}
	};
	
	
//
//	public List<ComBoardDto> list() {
//		String sql = "select * from Com_board order by com_board_no desc";
//		
//		return this.jdbcTemplate.query(sql, (rs, n) -> {
//			ComBoardDto boardDto = ComBoardDto.builder().number(rs.getInt("com_board_no"))
//					.title(rs.getString("com_title")).content(rs.getString("com_content")).hits(rs.getInt("com_hits"))
//					.nickname(rs.getString("nickname")).boardregdate(rs.getString("com_boardregdate")) // 날짜/시간 값 가져오기
//					.build();
//			return boardDto;
//		});
//	}
//	
	

	public ComBoardDto view(int com_board_no) {
		if (com_board_no <= 0) {
			throw new RuntimeException("해당 id는 글이 없습니다.");
		}
		String sql = "select * from Com_board where com_board_no = ?";
		return this.jdbcTemplate.queryForObject(sql, (rs, n) -> {
			ComBoardDto boardDto = ComBoardDto.builder().number(rs.getInt("com_board_no"))
					.title(rs.getString("com_title")).content(rs.getString("com_content")).hits(rs.getInt("com_hits"))
					.nickname(rs.getString("nickname")).boardregdate(rs.getString("com_boardregdate")) // 날짜/시간 값 가져오기
					.build();
			return boardDto;
		}, com_board_no);
	}

	public int write(ComBoardDto boardDto) {
		String sql = "INSERT INTO com_board(com_title, com_content, com_boardregdate, com_hits, nickname) VALUES (?, ?, NOW(), ?, ?)";
		return this.jdbcTemplate.update(sql, boardDto.getTitle(), boardDto.getContent(), 0, boardDto.getNickname()
//	        boardDto.getNickname()
		// 나중에 세션에서 닉네임 받아오기
		);
	}

	public int delete(int com_board_no) {
		String sql = "delete from com_board where com_board_no = ?";
		return this.jdbcTemplate.update(sql, com_board_no);
	}

	public void update(ComBoardDto boardDto) {
		jdbcTemplate.update(
				"update com_board set com_title = ?, com_content = ? ,com_boardregdate = NOW() where com_board_no = ?",
				boardDto.getTitle(), boardDto.getContent(),boardDto.getNumber());
	}
	public void comhitsUp(int com_board_no) {
		jdbcTemplate.update("update com_board set com_hits = com_hits + 1 where com_board_no = ?",
				com_board_no);
	}
	public int selectCount() {
		String sql = "select count(*) from com_board";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	
	public List<ComBoardDto> selectList(int startRow, int size) {
		String sql = "select * from com_board limit ?, ?";
		List<ComBoardDto> results = jdbcTemplate.query(sql, comRowMapper, startRow, size);
		return results;
	}
	
	public List<ComBoardDto> selectListup(int startRow, int size) {
		String sql = "SELECT * FROM com_board ORDER BY com_hits DESC LIMIT ?, ?";
		List<ComBoardDto> results = jdbcTemplate.query(sql, comRowMapper, startRow, size);
		return results;
	}
}
