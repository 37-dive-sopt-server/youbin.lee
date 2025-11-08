package org.sopt.domain.member;

import org.sopt.common.execption.CustomException;
import org.sopt.common.ErrorMessage;

public enum Gender {
    MALE("남"),
    FEMALE("여");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public static Gender from(String input) {
        for (Gender g : values()) {
            if (g.gender.equalsIgnoreCase(input)) {
                return g;
            }
        }
        throw new CustomException(ErrorMessage.INVALID_GENDER);
    }
}
