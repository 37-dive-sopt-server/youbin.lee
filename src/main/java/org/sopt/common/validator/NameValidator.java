package org.sopt.common.validator;

import org.sopt.common.execption.CustomException;
import org.sopt.common.ErrorMessage;

public class NameValidator {

    public static void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new CustomException(ErrorMessage.NAME_IS_REQUIRED);
        }
    }

}
