package org.sopt.application;

import org.sopt.application.dto.MemberCreateRequest;
import org.sopt.domain.Member;

import java.util.List;

public interface MemberService {
    Long join(MemberCreateRequest request);

    Member findByIdOrThrow(Long memberId);

    List<Member> findAllMembers();

    boolean deleteId(Long memberId);
}
