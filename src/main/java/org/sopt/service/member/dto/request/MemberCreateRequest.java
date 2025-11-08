package org.sopt.service.member.dto.request;

import java.time.LocalDate;

public record MemberCreateRequest(
        String name,
        LocalDate birthDate,
        String email,
        String gender
) {

}
