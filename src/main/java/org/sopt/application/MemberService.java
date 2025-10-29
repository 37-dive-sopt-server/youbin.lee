package org.sopt.application;

import org.sopt.application.dto.*;

public interface MemberService {
    MemberCreateResponse join(MemberCreateRequest request);

    MemberFindResponseDto findByIdOrThrow(Long memberId);

    MembersGetResponseDto findAllMembers();

    MemberDeleteResponseDto deleteId(Long memberId);
}
