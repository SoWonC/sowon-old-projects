package com.lyricskeeper.user.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lyricskeeper.user.dto.RegisterRequest;

public class RegisterRequestValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        // Validator가 지원하는 클래스 확인, 여기서는 RegisterRequest 클래스를 지원
        return RegisterRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 검증 대상 객체와 에러 객체를 받아 유효성 검사 수행

        // RegisterRequest 객체로 형변환
        RegisterRequest regReq = (RegisterRequest) target;

        // ID 필드 검증
        if (regReq.getId() == null || regReq.getId().trim().isEmpty()) {
            // ID가 비어있으면 "required" 에러 추가
            errors.rejectValue("id", "required");
        } else if (!regReq.getName().matches("^[가-힣]*$")) {
            errors.rejectValue("name", "invalid.name");
        }

        // 이름, 비밀번호, 확인 비밀번호 필드가 비어 있는지 검증
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required","이름을 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickname", "required","닉네임을 입력해주세요.");
        ValidationUtils.rejectIfEmpty(errors, "password", "required","비밀번호를 입력해주세요.");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required","비밀번호를 입력해주세요.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required","전화번호을 입력해주세요.");

        // 비밀번호와 확인 비밀번호가 일치하지 않으면 "notMatch" 에러 추가
        if (!regReq.getPassword().isEmpty()) {
            if (!regReq.isPasswordEqualToConfirmPassword()) {
                errors.rejectValue("confirmPassword", "notMatch.comfirmPassword");
            }
        }
    }
}