package org.sopt.application.dto;

import java.util.List;

public record MembersGetResponseDto(
        List<Long> id
) {
    public static MembersGetResponseDto from(
            List<Long> id
    ) {
        return new MembersGetResponseDto(id);
    }
}
