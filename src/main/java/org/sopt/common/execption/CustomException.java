package org.sopt.common.execption;

import org.sopt.common.execption.enums.ErrorMessage;

public class CustomException extends RuntimeException {

    public CustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

}
