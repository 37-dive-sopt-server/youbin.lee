package org.sopt.application.dto;

public record MemberDeleteResponseDto(
        boolean isDeleted
) {
    public static MemberDeleteResponseDto from(
            boolean isDeleted
    ) {
        return new MemberDeleteResponseDto(isDeleted);
    }
}
