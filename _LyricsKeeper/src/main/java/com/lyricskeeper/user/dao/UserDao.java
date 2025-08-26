package com.lyricskeeper.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.lyricskeeper.user.dto.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<User> userRowMapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"),
					rs.getString("NICKNAME"), rs.getString("PHONE"), rs.getTimestamp("REGDATE").toLocalDateTime());
			user.setUser_no(rs.getInt("USER_NO"));
			return user;
		}
	};

	public int selectCount() {
		String sql = "select count(*) from user";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public User selectByNum(int user_no) {
		String sql = "select * from user where user_no = ?";
		List<User> results = jdbcTemplate.query(sql, userRowMapper, user_no);
		return results.isEmpty() ? null : results.get(0);
	}

	public User selectById(String id) {
		String sql = "select * from user where id = ?";
		List<User> results = jdbcTemplate.query(sql, userRowMapper, id);
		return results.isEmpty() ? null : results.get(0);
	}
	public User selectByNickname(String nickname) {
		String sql = "select * from user where nickname = ?";
		List<User> results = jdbcTemplate.query(sql, userRowMapper, nickname);
		return results.isEmpty() ? null : results.get(0);
	}
	public List<User> selectByRegdate(LocalDateTime from, LocalDateTime to) {
		String sql = "select * from USER where REGDATE between ? and ? order by REGDATE desc";
		List<User> results = jdbcTemplate.query(sql, (rs, n) -> {
			User user = new User(rs.getString("ID"), rs.getString("PASSWORD"), rs.getString("NAME"),
					rs.getString("NICKNAME"), rs.getString("PHONE"), rs.getTimestamp("REGDATE").toLocalDateTime());
			user.setUser_no(rs.getInt("User_NO"));
			return user;
		}, from, to);
		return results;
	}

	public List<User> selectList(int startRow, int size) {
		String sql = "select * from user limit ?, ?";
		List<User> results = jdbcTemplate.query(sql, userRowMapper,startRow,size);
		return results;
	}

	public void insert(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "INSERT INTO user (id, password, name, nickname, phone, regdate) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql, new String[] { "USER_NO" });
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPassword());
				pstmt.setString(3, user.getName());
				pstmt.setString(4, user.getNickname());
				pstmt.setString(5, user.getPhone());
				pstmt.setTimestamp(6, Timestamp.valueOf(user.getRegisterDateTime()));

				return pstmt;
			}
		}, keyHolder);

	}

	public void update(User user) {
		String sql = "update USER set NAME = ?, PASSWORD = ?, NICKNAME = ?, PHONE = ? where id = ?";
		jdbcTemplate.update(sql, user.getName(), user.getPassword(), user.getNickname(), user.getPhone(), user.getId());
	}
	
	
	public void delete(User user) {
		String sql = "delete from USER where id = ?";
		jdbcTemplate.update(sql, user.getId());
	}

}
