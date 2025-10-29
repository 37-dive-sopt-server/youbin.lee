package org.sopt.application;

import org.sopt.application.dto.MemberCreateRequest;
import org.sopt.application.dto.MemberCreateResponse;
import org.sopt.application.dto.MemberFindResponseDto;
import org.sopt.application.dto.MembersGetResponseDto;

public interface MemberService {
    MemberCreateResponse join(MemberCreateRequest request);

    MemberFindResponseDto findByIdOrThrow(Long memberId);

    MembersGetResponseDto findAllMembers();

    boolean deleteId(Long memberId);
}
