package org.sopt.global.message;

public enum SuccessMessage {

    // 회원
    SUCCESS_CREATE_MEMBER(200, "회원 생성에 성공했습니다"),
    SUCCESS_GET_MEMBER(200, "회원 조회에 성공했습니다"),
    SUCCESS_GET_MEMBER_LIST(200, "전체 회원 조회에 성공했습니다"),
    SUCCESS_DELETED_MEMBERS(200, "회원 삭제에 성공했습니다"),

    // 아티클
    SUCCESS_CREATE_ARTICLE(200, "아티클 생성에 성공했습니다"),
    SUCCESS_GET_ARTICLE(200, "단일 아티클 조회에 성공했습니다"),
    SUCCESS_GET_ARTICLE_LIST(200, "전체 아티클 조회에 성공했습니다"),

    // 댓글
    SUCCESS_CREATE_COMMENT(200, "댓글 생성에 성공했습니다");

    private final int status;
    private final String message;

    SuccessMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
