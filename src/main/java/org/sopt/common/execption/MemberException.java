package org.sopt.common.execption;

import org.sopt.common.execption.enums.ErrorMessage;

public class MemberException extends RuntimeException {

    private ErrorMessage errorMessage;

    public MemberException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }

}
