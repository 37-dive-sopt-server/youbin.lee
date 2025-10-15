package org.sopt.service;

import org.sopt.domain.Gender;
import org.sopt.domain.Member;

import java.time.LocalDate;
import java.util.List;

public interface MemberService {
    Long join(String name, LocalDate birthDate, String email, Gender gender);

    Member findByIdOrThrow(Long memberId);

    List<Member> findAllMembers();

    void deleteId(Long memberId);
}
