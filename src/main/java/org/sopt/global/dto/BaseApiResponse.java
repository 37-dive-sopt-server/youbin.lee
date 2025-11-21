package org.sopt.global.dto;

import org.sopt.global.message.SuccessMessage;

public record BaseApiResponse<T>(
        int status,
        String message,
        T result
) {
    public static <T> BaseApiResponse of(SuccessMessage successMessage) {
        return new BaseApiResponse(successMessage.getStatus(), successMessage.getMessage(), null);
    }

    public static <T> BaseApiResponse of(SuccessMessage successMessage, T result) {
        return new BaseApiResponse(successMessage.getStatus(), successMessage.getMessage(), result);
    }
}
