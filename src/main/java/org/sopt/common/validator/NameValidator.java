package org.sopt.common.validator;

import org.sopt.common.execption.MemberException;
import org.sopt.common.execption.enums.ErrorMessage;

public class NameValidator {

    public static void validateName(String name) {
        if (name.trim().isEmpty()) {
            throw new MemberException(ErrorMessage.NAME_IS_REQUIRED);
        }
    }

}
