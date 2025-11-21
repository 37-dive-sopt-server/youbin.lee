package org.sopt.domain.member.validator;

import org.sopt.global.execption.CustomException;
import org.sopt.global.message.ErrorMessage;

public class NameValidator {

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new CustomException(ErrorMessage.NAME_IS_REQUIRED);
        }
    }

}
