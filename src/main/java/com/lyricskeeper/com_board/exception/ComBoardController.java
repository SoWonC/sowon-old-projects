package com.lyricskeeper.com_board.exception;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lyricskeeper.com_board.dto.ComBoardDto;
import com.lyricskeeper.com_board.spring.ComBoardDao;
import com.lyricskeeper.user.dto.AuthInfo;
import com.lyricskeeper.user.dto.User;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/com")
@Controller
@Slf4j
public class ComBoardController {

    @Autowired
    private ComBoardDao boardDao;

//     게시판 목록 조회(GET 방식)
//    @GetMapping("/list")
//    public String listcom(Model model, HttpServletRequest req) {
//        AuthInfo user = (AuthInfo) req.getSession().getAttribute("authInfo");
//        model.addAttribute("list", boardDao.list());
//        return "com_board/list"; // "com_board/list" 뷰로 이동합니다.
//    }
    
//    @GetMapping("/list2")
//    public String listcom2(Model model, HttpServletRequest req) {
//        AuthInfo user = (AuthInfo) req.getSession().getAttribute("authInfo");
//        model.addAttribute("list", boardDao.list());
//        return "com_board/list"; // "com_board/list" 뷰로 이동합니다.
//    }
//
//    // 게시판 목록 조회(POST 방식)
//    @PostMapping("/list")
//    public String root1(Model model, HttpServletRequest req) {
//        model.addAttribute("list", boardDao.list());
//        return "board/list"; // "board/list" 뷰로 이동합니다.
//    }

    // 게시물 작성 폼
    @GetMapping("/writeForm")
    public String writeForm(Model model, HttpServletRequest req) {
        AuthInfo user = (AuthInfo) req.getSession().getAttribute("authInfo");
        model.addAttribute("nick", user);
        return "com_board/writeForm";
    }
    
    // 게시물 작성
    @PostMapping("/writeForm")
    public String write(@Valid ComBoardDto boardDto, Model model,HttpServletRequest req,Error error) {
    	AuthInfo user = (AuthInfo) req.getSession().getAttribute("authInfo");
    	boardDto.setNickname(user.getNickname());
        boardDao.write(boardDto);
        return "com_board/finish";
    }

    // 게시물 상세 조회
    @GetMapping("/view")
    public String view(@RequestParam(value = "number", defaultValue = "0") int com_board_no, Model model) {
        try {
        ComBoardDto boardDto = null;
        boardDao.comhitsUp(com_board_no);
        boardDto = boardDao.view(com_board_no);
        model.addAttribute("dto", boardDto);
        return "com_board/view";	
		} catch (Exception e) {
			return "com_board/finish";
		}
		
    
    }



    // 게시물 삭제
    @GetMapping("/delete")
    public String delete(int number) {
        boardDao.delete(number);
        return "com_board/finish";
    }

    // 게시물 수정 폼
    @GetMapping("/update")
    public String update(@RequestParam(value = "number", defaultValue = "0") int com_board_no, Model model) {
        ComBoardDto boardDto = null;
        boardDto = boardDao.view(com_board_no);
        model.addAttribute("dto", boardDto);
        return "com_board/update"; // "com_board/update" 뷰로 이동합니다.
    }

    // 게시물 수정
    @PostMapping("/update")
    public String update1(ComBoardDto boardDto, Model model) {
        log.info(boardDto.toString());
        boardDao.update(boardDto);
        return "com_board/finish";
    }
}
