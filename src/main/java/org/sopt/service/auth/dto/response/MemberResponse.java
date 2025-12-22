package org.sopt.service.auth.dto.response;

import org.sopt.domain.member.Gender;
import org.sopt.domain.member.Member;

import java.time.LocalDate;

public record MemberResponse(
        Long id,
        String name,
        Gender gender,
        LocalDate birthDate,
        String email
) {
    public static MemberResponse from(Member m) {
        return new MemberResponse(
                m.getId(),
                m.getName(),
                m.getGender(),
                m.getBirthDate(),
                m.getEmail()
        );
    }

    public static MemberResponse of(Long id, String name, Gender gender, LocalDate birthDate, String email) {
        return new MemberResponse(id, name, gender, birthDate, email);
    }
}
