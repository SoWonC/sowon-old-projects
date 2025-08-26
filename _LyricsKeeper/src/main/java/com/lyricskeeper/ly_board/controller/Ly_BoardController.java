package com.lyricskeeper.ly_board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lyricskeeper.ly_board.dao.Ly_BoardDao;
import com.lyricskeeper.ly_board.dao.ThemaDao;
import com.lyricskeeper.ly_board.dto.Ly_Board;
import com.lyricskeeper.ly_board.dto.Ly_Board2;
import com.lyricskeeper.ly_board.dto.Ly_Board3;
import com.lyricskeeper.ly_board.dto.Ly_BoardDto;
import com.lyricskeeper.ly_board.dto.UserB;
import com.lyricskeeper.ly_board.exception.BoardNotFoundException;
import com.lyricskeeper.user.dao.UserDao;
import com.lyricskeeper.user.dto.AuthInfo;
import com.lyricskeeper.user.dto.User;

@RequestMapping("/secure")
@Controller
public class Ly_BoardController {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Ly_BoardDao ly_BoardDao;
	
	@Autowired
	private ThemaDao themaDao;
	
//	@GetMapping("/")
//	    public String main() {
//	        return "main"; // 반환할 JSP 파일 이름
//	    }
	
	@GetMapping("/boardMain")
	public String boardMain() {
		return "board/boardMain";
	}

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", ly_BoardDao.list());
		return "board/list";
	}
	
	@GetMapping("/write")
	public String listG(Model model) {
		model.addAttribute("thema", themaDao.list());
		
		return "board/writeBoard";
	}
	
	@PostMapping("/write")
	public String writeP(@ModelAttribute("ly_board3") @Valid Ly_Board3 ly_Board3, Model model,
	        HttpServletRequest req, RedirectAttributes redirectAttributes, Errors errors, HttpSession httpSession) {
		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo");
		User user = userDao.selectById(authInfo.getId());
	
		try {
			  // 게시글 생성 로직
		System.out.println(ly_Board3);
		System.out.println(user);
		String nickname = user.getNickname();
		String id = user.getId();
		ly_Board3.setId(id);
		ly_Board3.setNickname(nickname);
		System.out.println(nickname + id);
//		if (id == null || id.isEmpty()) {
//			redirectAttributes.addFlashAttribute("idnull", "yes");
//			return "redirect:/join";
//		}
//		if(nickname.isEmpty()) {
//			String message = "로그인 후 이용 가능한 서비스입니다.";
//		}
		System.out.println(ly_Board3);
		ly_BoardDao.write(ly_Board3);

		return "redirect:list";
		} catch(BoardNotFoundException e) {
			errors.rejectValue("boardNotFound", "게시물 등록이 실패하였습니다.");
			return "redirect:list";
		}
	}
	
	@GetMapping("/view")
	public String view(Model model, @RequestParam int ly_board_no, HttpServletRequest req, HttpSession httpSession) {
		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo");
		String id = httpSession.getId();
		System.out.println(id);
		User user = userDao.selectById(authInfo.getId());
		
		Ly_BoardDto dto = ly_BoardDao.view(ly_board_no);
		model.addAttribute("dto", ly_BoardDao.view(ly_board_no));
		System.out.println(req.getSession().getAttribute("authInfo"));
		if(!user.getId().equals(dto.getId())) {
			System.out.println(user.getId());
			ly_BoardDao.ly_hitsUp(ly_board_no);
		}

		return "board/view";
	}
	
	@GetMapping("/modify")
	public String modify(Model model,@RequestParam int ly_board_no,@ModelAttribute("ly_board") @Valid Ly_Board ly_board) {
		model.addAttribute("thema", themaDao.list());
		model.addAttribute("dto", ly_BoardDao.view(ly_board_no));
		return "board/modifyForm";
	}
	
	@PostMapping("/modify")
	public String modifyP(@ModelAttribute("ly_board") @Valid Ly_Board2 ly_Board2, Model model,
	        HttpServletRequest req, RedirectAttributes redirectAttributes, Errors errors, HttpSession httpSession) {
		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo");
		User user = userDao.selectById(authInfo.getId());

	    String nickname = user.getNickname();
	    String id = user.getId();
	    try {
	        // 게시글 생성 로직
	        System.out.println(ly_Board2);
	        ly_BoardDao.update(ly_Board2); // 데이터베이스 업데이트 로직 실행
	        return "redirect:list";
	    } catch (BoardNotFoundException e) {
	        errors.rejectValue("boardNotFound", "게시물 수정이 실패하였습니다.");
	        return "redirect:list";
	    }
	}
	
	@PostMapping("/delete")
	public String delete(Model model,@ModelAttribute("boardNo") @Valid int boardNo, HttpServletRequest req, HttpSession httpSession) {
		AuthInfo authInfo = (AuthInfo)httpSession.getAttribute("authInfo");
		User user = userDao.selectById(authInfo.getId());
		ly_BoardDao.delete(boardNo);

		return "redirect:list";
	}
	
}
