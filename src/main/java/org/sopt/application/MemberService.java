package org.sopt.application;

import org.sopt.application.dto.MemberCreateRequest;
import org.sopt.application.dto.MemberCreateResponse;
import org.sopt.application.dto.MemberFindResponseDto;
import org.sopt.domain.Member;

import java.util.List;

public interface MemberService {
    MemberCreateResponse join(MemberCreateRequest request);

    MemberFindResponseDto findByIdOrThrow(Long memberId);

    List<Member> findAllMembers();

    boolean deleteId(Long memberId);
}
