package org.sopt.common.execption.enums;

public enum ErrorMessage {

    // Member
    NAME_IS_REQUIRED("⚠️ 이름을 입력해주세요."),
    MEMBER_NOT_FOUND("⚠️ 해당 ID의 회원을 찾을 수 없습니다."),
    EMAIL_ALREADY_EXIST("⚠️ 이미 존재하는 이메일입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
