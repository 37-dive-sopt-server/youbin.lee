package org.sopt.domain.member.validator;

import org.sopt.global.execption.CustomException;
import org.sopt.global.message.ErrorMessage;

public class EmailValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public static void validateFormat(String email) {
        if (email == null || !email.matches(EMAIL_REGEX)) {
            throw new CustomException(ErrorMessage.INVALID_EMAIL_FORMAT);
        }
    }

}
