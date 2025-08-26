package com.lyricskeeper.user.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyricskeeper.user.dao.UserDao;
import com.lyricskeeper.user.dto.ListCommand;
import com.lyricskeeper.user.dto.User;
import com.lyricskeeper.user.dto.UserPage;
import com.lyricskeeper.user.exception.UserNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserListController {
	
	@Autowired
	private UserDao userDao;
	private int size = 5;

//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}

	public UserPage getUserPage(int pageNum, int pageSize) {

		int total = userDao.selectCount();
		List<User> user = userDao.selectList((pageNum - 1) * size, size);
		return new UserPage(total, pageNum, size, user);

	}
	

	@GetMapping("/users")
	public String listUser(Model model, @RequestParam(value = "pageNo", required = false) String pageNoVal) {
		int pageSize = 5; // 페이지 크기 설정 (한 페이지에 보여줄 회원 수)
		int pageNum = 1;

		if (pageNoVal != null) {
			pageNum = Integer.parseInt(pageNoVal);
		}
		UserPage userPage = getUserPage(pageNum, pageSize);
		model.addAttribute("userPage", userPage);
		return "user/userList";
	}

	@RequestMapping("/users/regdate")
	public String listByRegdate(@ModelAttribute("searchByRegdate") ListCommand listCommand, Errors errors,
			Model model) {
		if (errors.hasErrors()) {
			return "user/usersByRegdateList";
		}

		if (listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<User> usersByRegdate = userDao.selectByRegdate(listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("usersByRegdate", usersByRegdate);
			log.info("-------------------------검색한 기간안의 회원가입한 회원 목록을 가져옵니다", usersByRegdate);
		}
		return "user/usersByRegdateList";

	}
	
	

	@GetMapping("/users/{id}")
	public String detail(@PathVariable("id") String userId, Model model) {
		User user = userDao.selectById(userId);
		if (user == null) {
			throw new UserNotFoundException();
		}
		model.addAttribute("user", user);
		return "user/checkById";
	}

}
