package org.sopt.application.dto;

public record MemberFindResponseDto(
        Long id
) {
    public static MemberFindResponseDto from(
            Long id
    ) {
        return new MemberFindResponseDto(id);
    }
}
