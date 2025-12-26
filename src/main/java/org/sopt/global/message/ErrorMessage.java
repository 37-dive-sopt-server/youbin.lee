package org.sopt.global.message;

public enum ErrorMessage {

    // 회원
    NAME_IS_REQUIRED("⚠️ 이름을 입력해주세요."),
    MEMBER_NOT_FOUND("⚠️ 해당 ID의 회원을 찾을 수 없습니다."),
    EMAIL_ALREADY_EXIST("⚠️ 이미 존재하는 이메일입니다."),
    INVALID_EMAIL_FORMAT("⚠️ 올바르지 않은 이메일 형식입니다."),
    AGE_IS_UNDERAGE("⚠️ 20세 미만의 회원은 가입이 불가능합니다."),
    INVALID_GENDER("⚠️ 올바르지 않은 성별 값입니다."),

    // 아티클
    ARTICLE_NOT_FOUND("아티클을 찾을 수 없습니다"),
    ARTICLE_TITLE_DUPLICATE("아티클 제목은 중복이 불가능합니다"),

    // 댓글
    COMMENT_NOT_EXIST("댓글이 존재하지 않습니다"),
    COMMENT_NOT_IN_ARTICLE("해당 게시글의 댓글이 아닙니다"),
    COMMENT_UPDATE_FORBIDDEN("댓글 수정 권한이 없습니다"),
    COMMENT_DELETE_FORBIDDEN("댓글 삭제 권한이 없습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
