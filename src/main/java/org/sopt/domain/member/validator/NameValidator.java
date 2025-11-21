package org.sopt.domain.member.validator;

import org.sopt.common.execption.CustomException;
import org.sopt.common.message.ErrorMessage;

public class NameValidator {

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new CustomException(ErrorMessage.NAME_IS_REQUIRED);
        }
    }

}
