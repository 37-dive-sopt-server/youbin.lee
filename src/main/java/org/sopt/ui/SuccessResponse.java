package org.sopt.ui;

import org.sopt.common.success.enums.SuccessMessage;

public record SuccessResponse<T>(
        int status,
        String message,
        T result
) {
    public static <T> SuccessResponse of(SuccessMessage successMessage, T result) {
        return new SuccessResponse(successMessage.getStatus(), successMessage.getMessage(), result);
    }
}
