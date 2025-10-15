package org.sopt.common.execption.enums;

public enum ErrorMessage {

    MEMBER_NOT_FOUND("존재하지 않는 회원입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
