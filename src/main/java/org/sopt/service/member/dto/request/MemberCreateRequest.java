package org.sopt.service.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record MemberCreateRequest(
        @NotBlank
        String name,
        LocalDate birthDate,
        @NotBlank
        @Email
        String email,
        String gender
) {

}
