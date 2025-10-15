package org.sopt.common.execption;

import org.sopt.common.execption.enums.ErrorMessage;

public class CustomException extends RuntimeException {

    private ErrorMessage errorMessage;

    public CustomException(ErrorMessage errorMessage) {
        this.errorMessage = errorMessage;
    }

}
