package com.lyricskeeper.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyricskeeper.user.dao.UserDao;
import com.lyricskeeper.user.dto.AuthInfo;
import com.lyricskeeper.user.dto.User;
import com.lyricskeeper.user.exception.WrongIdPasswordException;

@Service
public class AuthService {
	
	@Autowired
	private UserDao userDao;

		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}

		public AuthInfo authenticate(String id, String password) {
			User user = userDao.selectById(id);
			if (user == null) {
				throw new WrongIdPasswordException();
			}
			if (!user.matchPassword(password)) {
				throw new WrongIdPasswordException();
			}
			return new AuthInfo(user.getId(),
					user.getName(), user.getNickname(), user.getPhone());
		}

	}


