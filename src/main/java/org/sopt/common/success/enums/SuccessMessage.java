package org.sopt.common.success.enums;

public enum SuccessMessage {

    // 회원 생성
    SUCCESS_CREATE_MEMBER(200, "회원 생성에 성공했습니다");

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
