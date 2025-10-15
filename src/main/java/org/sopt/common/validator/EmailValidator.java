package org.sopt.common.validator;

import org.sopt.common.execption.enums.ErrorMessage;

public class EmailValidator {

    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public static void validateFormat(String email) {
        if (email == null || !email.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_EMAIL_FORMAT.getMessage());
        }
    }

}
