package org.sopt.ui;

import org.sopt.common.SuccessMessage;

public record SuccessResponse<T>(
        int status,
        String message,
        T result
) {
    public static <T> SuccessResponse of(SuccessMessage successMessage){
        return new SuccessResponse(successMessage.getStatus(), successMessage.getMessage(), null);
    }

    public static <T> SuccessResponse of(SuccessMessage successMessage, T result) {
        return new SuccessResponse(successMessage.getStatus(), successMessage.getMessage(), result);
    }
}
