package org.sopt.common.validator;

import org.sopt.common.execption.enums.ErrorMessage;

public class NameValidator {

    public static void validateName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_IS_REQUIRED.getMessage());
        }
    }

}
