package com.lyricskeeper.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyricskeeper.user.dao.UserDao;
import com.lyricskeeper.user.dto.User;
import com.lyricskeeper.user.exception.UserNotFoundException;

@Repository
public class ChangePasswordService {
	private UserDao userDao;
	@Transactional
	public void changePassword(String id, String oldPwd, String newPwd) {
		User user = userDao.selectById(id);
		if (user == null)
			throw new UserNotFoundException();
		user.changePassword(oldPwd, newPwd);
		userDao.update(user);
	}
	public void setUserDao(UserDao UserDao) {
		this.userDao = UserDao;
	}
}
