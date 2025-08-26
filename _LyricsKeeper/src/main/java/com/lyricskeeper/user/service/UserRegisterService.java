package com.lyricskeeper.user.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyricskeeper.user.dao.UserDao;
import com.lyricskeeper.user.dto.RegisterRequest;
import com.lyricskeeper.user.dto.User;
import com.lyricskeeper.user.exception.DuplicateUserException;

@Service
public class UserRegisterService {
	
	@Autowired
	private UserDao userDao;
	
	public UserRegisterService(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public int regist(RegisterRequest req) {
		User userWithId = userDao.selectById(req.getId());

		if (userWithId != null) {
	        throw new DuplicateUserException("dup id " + req.getId());
	    }
		User newUser = new User(req.getId(),req.getPassword(),req.getName(),req.getNickname(),req.getPhone(),LocalDateTime.now());
		userDao.insert(newUser);
		return newUser.getUser_no();
		
	}
	

}
