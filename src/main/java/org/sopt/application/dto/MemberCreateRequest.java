package org.sopt.application.dto;

import java.time.LocalDate;

public record MemberCreateRequest(
        String name,
        LocalDate birthDate,
        String email,
        String gender
) {

}
