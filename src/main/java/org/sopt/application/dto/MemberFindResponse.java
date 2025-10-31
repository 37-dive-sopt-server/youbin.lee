package org.sopt.application.dto;

public record MemberFindResponse(
        Long id
) {
    public static MemberFindResponse from(
            Long id
    ) {
        return new MemberFindResponse(id);
    }
}
