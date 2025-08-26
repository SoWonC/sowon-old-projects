package com.lyricskeeper.ly_board.exception;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lyricskeeper.ly_board.dto.Ly_Board;

@Component
public class Ly_BoardValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Ly_Board.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		 Ly_Board lyBoard = (Ly_Board) target;

	        // 필드 검증 예제: 필드가 비어있는지 확인
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ly_title", "required.ly_title", "제목을 입력하세요.");
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ly_content", "required.ly_content", "내용을 입력하세요.");
	        
	        // 여기에 추가적인 검증 룰을 적용할 수 있습니다.
	        // 예: 글자 수, 특정 패턴 등
	        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "tag_name", "required.tag_name", "태그를 선택하세요.");
	        // tag_name에 대한 검증 룰을 추가할 수 있습니다.
		
	}

}
