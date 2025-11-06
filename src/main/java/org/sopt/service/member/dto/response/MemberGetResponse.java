package org.sopt.service.member.dto.response;

public record MemberGetResponse(
        Long id
) {
    public static MemberGetResponse from(Long id) {
        return new MemberGetResponse(id);
    }
}
