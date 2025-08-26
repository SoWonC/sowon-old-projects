package com.lyricskeeper.com_board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyricskeeper.com_board.dto.ComBoardDto;
import com.lyricskeeper.com_board.dto.Com_Page;
import com.lyricskeeper.com_board.spring.ComBoardDao;
import com.lyricskeeper.user.dto.UserPage;

import lombok.extern.slf4j.Slf4j;
@RequestMapping("/com")
@Controller
@Slf4j
public class ComListController {

	@Autowired
	private ComBoardDao comBoardDao;
	private int size = 5; // 한 페이지에 보여줄 회원 수를 설정합니다.

//	public void setUserDao(ComBoardDao comBoardDao) {
//		this.comBoardDao = comBoardDao;
//	}

	// 페이지 번호와 페이지 크기를 입력받아 UserPage 객체를 생성하여 반환하는 메서드입니다.
	public Com_Page getComPage(int pageNum, int pageSize) {

		int total = comBoardDao.selectCount();
		List<ComBoardDto> com = comBoardDao.selectList((pageNum - 1) * size, size);
		return new Com_Page(total, pageNum, size, com);

	}
	
	public Com_Page getComPageup(int pageNum, int pageSize) {

		int total = comBoardDao.selectCount();
		List<ComBoardDto> com = comBoardDao.selectListup((pageNum - 1) * size, size);
		return new Com_Page(total, pageNum, size, com);

	}

	// 사용자 목록을 조회하고 페이지 번호를 처리하는 메서드입니다.
	@GetMapping("list")
	public String listCom(Model model, @RequestParam(value = "pageNo", required = false) String pageNo) {
		int pageSize = 5; // 페이지 크기 설정 (한 페이지에 보여줄 회원 수)
		int pageNum = 1;
		
		if (pageNo != null) {
			pageNum = Integer.parseInt(pageNo); // 페이지 번호를 가져옵니다.
		}
		Com_Page com_Page = getComPage(pageNum, pageSize); // 페이지 정보를 가져와 모델에 추가합니다.
		model.addAttribute("com_Page", com_Page);
		log.info("000000000000000000000000000000000000000"+com_Page);
		return "com_board/list"; // 사용자 목록 페이지로 이동합니다.
	}
	
	
	@GetMapping("listup")
	public String listComup(Model model, @RequestParam(value = "pageNo", required = false) String pageNo) {
		int pageSize = 5; // 페이지 크기 설정 (한 페이지에 보여줄 회원 수)
		int pageNum = 1;
		
		if (pageNo != null) {
			pageNum = Integer.parseInt(pageNo); // 페이지 번호를 가져옵니다.
		}
		Com_Page com_Page = getComPageup(pageNum, pageSize); // 페이지 정보를 가져와 모델에 추가합니다.
		model.addAttribute("com_Page", com_Page);
		return "com_board/listup"; // 사용자 목록 페이지로 이동합니다.
	}



	}
