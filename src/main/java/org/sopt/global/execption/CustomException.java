package org.sopt.global.execption;

import org.sopt.global.message.ErrorMessage;

public class CustomException extends RuntimeException {

    public CustomException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

}
