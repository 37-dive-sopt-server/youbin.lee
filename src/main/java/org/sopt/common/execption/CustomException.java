package org.sopt.common.execption;

import org.sopt.common.message.ErrorMessage;

public class CustomException extends RuntimeException {

    public CustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

}
