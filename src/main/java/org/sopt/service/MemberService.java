package org.sopt.service;

import org.sopt.domain.Member;

import java.time.LocalDate;
import java.util.List;

public interface MemberService {
    Long join(String name, LocalDate birthDate, String email, String gender);

    Member findByIdOrThrow(Long memberId);

    List<Member> findAllMembers();

    boolean deleteId(Long memberId);
}
